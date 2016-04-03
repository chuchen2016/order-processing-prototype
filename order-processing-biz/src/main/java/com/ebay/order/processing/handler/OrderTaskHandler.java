package com.ebay.order.processing.handler;

import java.util.List;

import com.ebay.order.processing.model.dataObject.OrderTaskDO;


/**
 * 查询待处理的订单处理任务
 * 创建下一个阶段的订单处理任务
 * @author chuchen
 *
 */
public interface OrderTaskHandler {
	
	
	/**
	 * 查询当前阶段需要处理的订单任务
	 * @return
	 **/
	public List<OrderTaskDO> queryUnProcessedTask(String key);
	
	
	/**
	 * 当前阶段执行成功后创建下一个阶段的订单处理任务
	 * @param orderTaskDO
	 * @return
	 **/
	public void createNextStepOnSuccess(OrderTaskDO orderTaskDO);
	
	
	/**
	 * 当前阶段执行失败时创建下一个阶段的订单处理任务
	 * @param orderTaskDO
	 * @return
	 **/
	public void createNextStepOnFailure(OrderTaskDO orderTaskDO);
}
