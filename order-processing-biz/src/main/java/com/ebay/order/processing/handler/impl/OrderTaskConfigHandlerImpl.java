package com.ebay.order.processing.handler.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebay.order.processing.dao.OrderTaskConfigDAO;
import com.ebay.order.processing.handler.OrderTaskConfigHandler;
import com.ebay.order.processing.model.dataObject.OrderTaskConfigDO;

/**
 * 该类用于处理分布式环境下的多个数据处理节点的调度信息注册与取消
 * @author chuchen
 *
 */
@Service("orderTaskConfigHandler")
public class OrderTaskConfigHandlerImpl implements OrderTaskConfigHandler {
	
	@Autowired
	private OrderTaskConfigDAO orderTaskConfigDAO;
	
	private static Logger logger = Logger.getLogger(OrderTaskConfigHandlerImpl.class);
	
	@Override
	public Boolean register(String key, Date validTime) {
		if(StringUtils.isBlank(key) || validTime == null){
			return false;
		}
		try{
			OrderTaskConfigDO orderTaskConfigDO = new OrderTaskConfigDO();
			orderTaskConfigDO.setKey(key);
			orderTaskConfigDO.setCreateTime(new Date());
			orderTaskConfigDO.setValidTime(validTime);
			orderTaskConfigDO.setUpdateTime(new Date());
			orderTaskConfigDAO.insertOnduplicateUpadte(orderTaskConfigDO);
			return true;
		}catch(Exception e){
			logger.error("exception happened in register,key="+key+",validaTime="+validTime,e);
			return false;
		}
	}

	@Override
	public Boolean unRegister(String key) {
		if(StringUtils.isBlank(key)){
			return false;
		}
		try{
			OrderTaskConfigDO orderTaskConfigDO = new OrderTaskConfigDO();
			orderTaskConfigDO.setKey(key);
			orderTaskConfigDO.setCreateTime(new Date());
			orderTaskConfigDO.setValidTime(new Date());//失效时间设置为当前即为取消注册
			orderTaskConfigDO.setUpdateTime(new Date());
			orderTaskConfigDAO.insertOnduplicateUpadte(orderTaskConfigDO);
			return true;
		}catch(Exception e){
			logger.error("exception happened in register,key="+key,e);
			return false;
		}
	}
	
	/**
	 * 查询当前机器处于处理任务的机器列表的哪个位置
	 */
	@Override
	public Integer queryCurrentTaskRange(String key) {
		return 5;//mockUp
	}
	
	/**
	 * 查询当前总共多少机器在处理任务
	 */
	@Override
	public Integer queryCurrentTaskCount() {
		return 10;//mockUp
	}

}
