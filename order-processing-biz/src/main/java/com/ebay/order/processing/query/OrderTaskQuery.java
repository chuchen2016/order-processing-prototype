package com.ebay.order.processing.query;

import java.io.Serializable;
import java.util.Date;

public class OrderTaskQuery implements Serializable {

	private static final long serialVersionUID = -4027365963878954595L;
	
	private Long orderId;
	
	private Byte status;
	
	private Byte type;
	
	private Date timeRangeStart;//查询任务创建时间在timeRangeStart之前的所有任务
	
	private Date timeRangeEnd;//查询任务创建时间在timeRangeStart之后的所有任务
	
	private Integer modNum;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public Date getTimeRangeStart() {
		return timeRangeStart;
	}

	public void setTimeRangeStart(Date timeRangeStart) {
		this.timeRangeStart = timeRangeStart;
	}

	public Date getTimeRangeEnd() {
		return timeRangeEnd;
	}

	public void setTimeRangeEnd(Date timeRangeEnd) {
		this.timeRangeEnd = timeRangeEnd;
	}

	public Integer getModNum() {
		return modNum;
	}

	public void setModNum(Integer modNum) {
		this.modNum = modNum;
	}
	
}
