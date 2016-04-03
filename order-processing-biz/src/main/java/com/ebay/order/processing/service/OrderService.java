package com.ebay.order.processing.service;

import com.ebay.order.api.dto.OrderDTO;
import com.ebay.order.api.dto.OrderSubmitParam;
import com.ebay.order.api.dto.Result;


/**
 * 查询待处理的订单处理任务
 * 创建下一个阶段的订单处理任务
 * @author chuchen
 *
 **/
public interface OrderService {
	
	/**
	 * 查询当前阶段需要处理的订单任务
	 * @return
	 **/
	public OrderDTO queryOrder(Long orderId);
	
	/**
	 * 用户提交订单信息
	 * @param orderSubmitParam
	 * @return 返回生成的订单ID
	 */
	public Result<Long> submitOrder(OrderSubmitParam orderSubmitParam);
}
