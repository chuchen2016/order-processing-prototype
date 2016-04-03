package com.ebay.order.processing.dao;

import java.util.List;

import com.ebay.order.processing.model.dataObject.OrderTaskConfigDO;
import com.ebay.order.processing.query.OrderTaskConfigQuery;

/**
 * 读取机器配置信息
 * 确定当前任务被派发到哪台机器上执行
 * 配置表对应的DAO
 * @author chuchen
 *
 */
public interface OrderTaskConfigDAO {

	/**
	 * 
	 * @param orderTaskQuery
	 * @return
	 */
	public List<OrderTaskConfigDO> queryOrderTaskConfig(OrderTaskConfigQuery orderTaskConfigQuery);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public OrderTaskConfigDO queryTaskConfigByPrimaryKey(Long id);
	
	
	/**
	 * 
	 * @param orderId
	 * @param type
	 * @return
	 */
	public OrderTaskConfigDO queryOrderTaskByUniqueKey(Integer orderId,Byte type);
	
	/**
	 * 
	 * @param orderTaskDO
	 * @return
	 */
	public Integer insertOnduplicateUpadte(OrderTaskConfigDO orderTaskConfigDO);
	
	
	/**
	 * 
	 * @param orderTaskDO : 更新的内容
	 * @param example : 更新条件
	 * @return
	 */
	public Integer updateOrderTaskDOByExample(OrderTaskConfigDO orderTaskDO,OrderTaskConfigDO example);
	
	
}