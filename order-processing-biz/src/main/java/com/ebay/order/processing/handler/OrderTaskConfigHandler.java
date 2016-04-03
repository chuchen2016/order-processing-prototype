package com.ebay.order.processing.handler;

import java.util.Date;

public interface OrderTaskConfigHandler {
	
	/**
	 * 将当前机器注册到列表中
	 * @param key
	 * @param validTime
	 * @return
	 */
	public Boolean register(String key,Date validTime);
	
	
	/**
	 * 创建下一个阶段的订单处理任务
	 * @param orderTaskDO
	 * @return
	 */
	public Boolean unRegister(String key);
	
	
	/**
	 * 查询当前机器处于配置列表里的第几个位置
	 * 那么该机器只需要从数据库中取出 orderId % count = modNum 
	 * count的描述参考下一个方法
	 * 所对应的task
	 * @param key
	 * @return
	 */
	public Integer queryCurrentTaskRange(String key);
	
	
	/**
	 * 查询当前机器处于配置列表里的第几个位置
	 * 那么该机器只需要从数据库中取出 orderId % count = modNum 
	 * count即为当前已经注册的机器数
	 * @return
	 **/
	public Integer queryCurrentTaskCount();
}
