package com.ebay.order.processing.model.dataObject;

import java.io.Serializable;

public class OrderDO implements Serializable {

	private static final long serialVersionUID = -5336513031458562857L;
	
	private Long orderId;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	//some other info.........
}
