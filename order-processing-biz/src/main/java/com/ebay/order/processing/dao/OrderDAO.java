package com.ebay.order.processing.dao;

import java.util.List;

import com.ebay.order.processing.model.dataObject.OrderDO;
import com.ebay.order.processing.query.OrderQuery;

/**
 * 
 * @author chuchen
 *
 */
public interface OrderDAO {

	/**
	 * 
	 * @param orderTaskQuery
	 * @return
	 */
	public List<OrderDO> queryOrderTask(OrderQuery orderTaskQuery);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public OrderDO queryOrderByPrimaryKey(Long id);
	
	
	/**
	 * 
	 * @param orderTaskDO
	 * @return
	 */
	public Long insertOnduplicateUpadte(OrderDO orderDO);
	
	
	/**
	 * 
	 * @param orderDO : 更新的内容
	 * @param example : 更新条件
	 * @return
	 */
	public Integer updateOrderTaskDOByExample(OrderDO orderDO,OrderDO example);
	
	
}