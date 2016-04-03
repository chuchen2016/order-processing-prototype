package com.ebay.order.processing.query;

import java.io.Serializable;

public class OrderQuery implements Serializable {
	
	private static final long serialVersionUID = 1615440500977370552L;
	
	private Integer orderId;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	
	
}
