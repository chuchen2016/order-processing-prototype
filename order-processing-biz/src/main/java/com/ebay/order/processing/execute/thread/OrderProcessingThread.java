package com.ebay.order.processing.execute.thread;

import com.ebay.order.processing.executor.OrderTaskExecutor;
import com.ebay.order.processing.model.dataObject.OrderTaskDO;

public class OrderProcessingThread implements Runnable {
	
	private OrderTaskDO data;
	
	private OrderTaskExecutor orderTaskExecutor;
	
	@Override
	public void run() {
		try{
			orderTaskExecutor.execute(data);
			onSuccess();
		}catch(Exception e){
			onFailure();
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