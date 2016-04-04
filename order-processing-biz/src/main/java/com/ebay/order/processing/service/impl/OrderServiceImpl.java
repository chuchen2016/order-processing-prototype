package com.ebay.order.processing.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ebay.order.api.dto.OrderDTO;
import com.ebay.order.api.dto.OrderStepDTO;
import com.ebay.order.api.dto.OrderSubmitParam;
import com.ebay.order.api.dto.Result;
import com.ebay.order.processing.dao.OrderDAO;
import com.ebay.order.processing.dao.OrderTaskDAO;
import com.ebay.order.processing.enums.TaskStatusEnum;
import com.ebay.order.processing.enums.TaskTypeEnum;
import com.ebay.order.processing.model.dataObject.OrderDO;
import com.ebay.order.processing.model.dataObject.OrderTaskDO;
import com.ebay.order.processing.query.OrderTaskQuery;
import com.ebay.order.processing.service.OrderService;


/**
 * 对外提供订单相关的服务
 * 用户查询订单
 * 用户提交订单
 * @author chuchen
 *
 */

public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private OrderTaskDAO orderTaskDAO;
	
	
	@Override
	public Result<Long> submitOrder(OrderSubmitParam orderSubmitParam) {
		Result<Long> result = new Result<Long>();
		OrderDO orderDO = new OrderDO();
		//set some properties
		Long orderId = orderDAO.insertOnduplicateUpadte(orderDO);//通过设置insert语句的返回得到orderId
		if(orderId != null && orderId > 0){
			OrderTaskDO orderTaskDO = new OrderTaskDO();
			orderTaskDO.setOrderId(orderId);
			orderTaskDO.setStatus(TaskStatusEnum.UNEXECUTED.status);
			orderTaskDO.setType(TaskTypeEnum.PRE_EXECUTE.taskType);
			orderTaskDAO.insertOnduplicateUpadte(orderTaskDO);
			result.setData(orderId);
			result.setSuccess(true);
		}else{
			result.setSuccess(false);
			result.setInfo("没能正确生成订单ID");
		}
		
		return result;
	}

	@Override
	public OrderDTO queryOrder(Long orderId) {
		OrderTaskQuery orderTaskQuery = new OrderTaskQuery();
		OrderDTO result = new OrderDTO();
		orderTaskQuery.setOrderId(orderId);
		List<OrderTaskDO> taskList = orderTaskDAO.queryOrderTask(orderTaskQuery);//查询根据主键降序排列
		if(taskList == null || taskList.size() <= 0){
			//empty result
			return result;
		}
		OrderTaskDO current = taskList.get(0);
		result.setCreateTime(current.getCreateTime());
		result.setCompletedTime(current.getCompletedTime());
		result.setCurrentStatus(current.getStatus());
		result.setCurrentType(current.getStep());
		//查询各个阶段的情况
		List<OrderStepDTO>  steps = new ArrayList<OrderStepDTO>();
		for(int i = 1; i <= taskList.size() ;i++){
			OrderStepDTO step = new OrderStepDTO();
			step.setCompletedTime(current.getCompletedTime());
			step.setStartTime(current.getCreateTime());
			steps.add(step);
		}
		result.setSteps(steps);
		return result;
	}

}
