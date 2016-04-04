package com.ebay.order.processing.model.dataObject;

import java.io.Serializable;
import java.util.Date;

public class OrderTaskDO implements Serializable {

	private static final long serialVersionUID = 8854587494889824763L;
	
	private Long id;
	
	private Long orderId;
	
	private Byte step;
	
	private Byte status;
	
	private Date createTime;
	
	private Date completedTime;
	
	private Integer count;//该任务在当前阶段被执行了多少次了
	
	private String context;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Byte getStep() {
		return step;
	}

	public void setType(Byte type) {
		this.step = type;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
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

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public void setStep(Byte step) {
		this.step = step;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}
