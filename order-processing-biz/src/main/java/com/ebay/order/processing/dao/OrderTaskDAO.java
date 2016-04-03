package com.ebay.order.processing.dao;

import java.util.List;

import com.ebay.order.processing.model.dataObject.OrderTaskConfigDO;
import com.ebay.order.processing.model.dataObject.OrderTaskDO;
import com.ebay.order.processing.query.OrderTaskQuery;

/**
 * 
 * @author chuchen
 *
 */
public interface OrderTaskDAO {

	/**
	 * 
	 * @param orderTaskQuery
	 * @return
	 */
	public List<OrderTaskDO> queryOrderTask(OrderTaskQuery orderTaskQuery);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public OrderTaskConfigDO queryOrderTaskByPrimaryKey(Long id);
	
	
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
	public Integer insertOnduplicateUpadte(OrderTaskDO orderTaskDO);
	
	
	/**
	 * 
	 * @param orderTaskDO : 更新的内容
	 * @param example : 更新条件
	 * @return
	 */
	public Integer updateOrderTaskDOByExample(OrderTaskDO orderTaskDO,OrderTaskDO example);
	
	
}