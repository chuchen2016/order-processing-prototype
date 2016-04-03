package com.ebay.order.api.dto;

import java.io.Serializable;
import java.util.Date;

public class OrderStepDTO implements Serializable {

	private static final long serialVersionUID = -8814090469325070356L;
	
	private Date startTime;
	
	private Date completedTime;

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getCompletedTime() {
		return completedTime;
	}

	public void setCompletedTime(Date completedTime) {
		this.completedTime = completedTime;
	}
	
}
