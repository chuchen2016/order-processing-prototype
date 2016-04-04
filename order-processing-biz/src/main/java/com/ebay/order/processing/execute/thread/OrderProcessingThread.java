package com.ebay.order.processing.execute.thread;

import org.apache.log4j.Logger;

import com.ebay.order.processing.executor.OrderTaskExecutor;
import com.ebay.order.processing.model.dataObject.OrderTaskDO;

public class OrderProcessingThread implements Runnable {
	
	private OrderTaskDO data;
	
	private OrderTaskExecutor orderTaskExecutor;
	
	private static Logger logger = Logger.getLogger(OrderProcessingThread.class);
	
	@Override
	public void run() {
		try{
			orderTaskExecutor.execute(data);
			onSuccess();
		}catch(Exception e){
			onFailure();
			logger.error("order data process exception,orderId="
					+ data.getOrderId()+",type="+data.getStep(),e);
		}
	}

	public OrderTaskDO getData() {
		return data;
	}

	public void setData(OrderTaskDO data) {
		this.data = data;
	}
	
	
	protected void execute(){
		orderTaskExecutor.execute(data);
	}
	

	protected void onFailure() {
		orderTaskExecutor.onFailure(data);
	}

	protected void onSuccess() {
		orderTaskExecutor.onSuccess(data);
	}

	public OrderTaskExecutor getOrderTaskExecutor() {
		return orderTaskExecutor;
	}

	public void setOrderTaskExecutor(OrderTaskExecutor orderTaskExecutor) {
		this.orderTaskExecutor = orderTaskExecutor;
	}
	
}