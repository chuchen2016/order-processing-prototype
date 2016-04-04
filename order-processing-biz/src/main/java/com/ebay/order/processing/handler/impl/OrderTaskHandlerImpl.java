package com.ebay.order.processing.handler.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ebay.order.processing.dao.OrderTaskDAO;
import com.ebay.order.processing.enums.TaskStatusEnum;
import com.ebay.order.processing.enums.TaskTypeEnum;
import com.ebay.order.processing.handler.OrderTaskConfigHandler;
import com.ebay.order.processing.handler.OrderTaskHandler;
import com.ebay.order.processing.model.dataObject.OrderTaskDO;
import com.ebay.order.processing.query.OrderTaskQuery;


@Service("orderTaskHandler")
public class OrderTaskHandlerImpl implements OrderTaskHandler {
	
	@Resource
	OrderTaskDAO orderTaskDAO;
	
	@Resource
	OrderTaskConfigHandler orderTaskConfigService;
	
	private static Logger logger = Logger.getLogger(OrderTaskHandlerImpl.class);
	
	@Override
	public List<OrderTaskDO> queryUnProcessedTask(String key) {
		try{
			//先查询出来当前总共有多少个任务
			Integer count = orderTaskConfigService.queryCurrentTaskCount();
			//查询当前机器处于任务列表的第几个位置
			Integer modNum = orderTaskConfigService.queryCurrentTaskRange(key);
			OrderTaskQuery orderTaskQuery = new OrderTaskQuery();
			//1小时以前的时间点
			Date rangeStart = new Date();
			//查询出来的任务创建时间需要大于等于该时间
			orderTaskQuery.setTimeRangeStart(rangeStart);
			orderTaskQuery.setModNum(modNum%count);
			/**
			 * select order_id,status,type,create_time,completed_time 
			 * 
			 * from 
			 * 		Order_Task 
			 * 
			 * where 
			 * 		create_time >= rangeStart and mod_num = modNum
			 **/
			return orderTaskDAO.queryOrderTask(orderTaskQuery);
		}catch(Exception e){
			logger.error("queryUnProcessedTask exception key="+key,e);
			return null;
		}
	}

	@Override
	public void createNextStepOnSuccess(OrderTaskDO orderTaskDO) {
		OrderTaskDO nextStep = new OrderTaskDO();
		nextStep.setStatus(TaskStatusEnum.UNEXECUTED.status);
		//当前节点的下一步类型,通过枚举中的nextStep来配置
		nextStep.setType(TaskTypeEnum.getTaskByType(orderTaskDO.getStep()).nextType);
		nextStep.setOrderId(orderTaskDO.getOrderId());
		nextStep.setContext(orderTaskDO.getContext());
		orderTaskDAO.insertOnduplicateUpadte(nextStep);
	}

	@Override
	public void createNextStepOnFailure(OrderTaskDO orderTaskDO) {
		OrderTaskDO nextStep = new OrderTaskDO();
		//当前节点的状态为初始化
		nextStep.setStatus(TaskStatusEnum.UNEXECUTED.status);
		//当前节点的下一步类型,因为出错了
		nextStep.setType(TaskTypeEnum.FAILED.taskType);
		nextStep.setOrderId(orderTaskDO.getOrderId());
		nextStep.setContext(orderTaskDO.getContext());
		orderTaskDAO.insertOnduplicateUpadte(nextStep);
	}

	@Override//任务执行成功后修改执行状态,修改任务执行次数,失败次数超过五次不再重试
	public Integer updateOrderTask(OrderTaskDO orderTaskDO, Long orderId, Byte type) {
		if(orderTaskDO == null || orderId == null || type == null){
			return 0;
		}
		OrderTaskDO example = new OrderTaskDO();
		example.setOrderId(orderId);
		example.setType(type);
		return orderTaskDAO.updateOrderTaskDOByExample(orderTaskDO, example);
	}

}
