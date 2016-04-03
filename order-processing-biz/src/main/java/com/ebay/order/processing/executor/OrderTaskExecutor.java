package com.ebay.order.processing.executor;

import com.ebay.order.processing.model.dataObject.OrderTaskDO;

public interface OrderTaskExecutor {
	
	/**
	 * 
	 **/
	public void execute(OrderTaskDO task);
	
	/**
	 * 该阶段订单处理成功后需要做的事情
	 **/
	public void onSuccess(OrderTaskDO task);
	
	
	/**
	 * 该阶段订单处理发生异常时需要做的事情
	 */
	public void onFailure(OrderTaskDO task);
	
}
