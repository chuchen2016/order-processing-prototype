package com.ebay.order.api.dto;

import java.util.Date;
import java.util.List;
import java.io.Serializable;

public class OrderDTO implements Serializable{

	private static final long serialVersionUID = -6337820502479055625L;
	
	private Long orderId;
	
	private Date createTime;
	
	private Date completedTime;
	
	private Byte currentType;
	
	private Byte currentStatus;
	
	private List<OrderStepDTO> steps;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCompletedTime() {
		return completedTime;
	}

	public void setCompletedTime(Date completedTime) {
		this.completedTime = completedTime;
	}

	public Byte getCurrentType() {
		return currentType;
	}

	public void setCurrentType(Byte currentType) {
		this.currentType = currentType;
	}

	public Byte getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(Byte currentStatus) {
		this.currentStatus = currentStatus;
	}

	public List<OrderStepDTO> getSteps() {
		return steps;
	}
	
	public void setSteps(List<OrderStepDTO> steps) {
		this.steps = steps;
	}
	
}
