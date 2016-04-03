package com.ebay.order.processing.query;

import java.util.Date;
import java.io.Serializable;

public class OrderTaskConfigQuery implements Serializable {

	private static final long serialVersionUID = -6148750901951887496L;

	private Long id;
	
	private String key;
	
	private Date validTime;//该配置有效期截止时间
	
	private Date addTime;
	
	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Date getValidTime() {
		return validTime;
	}
	
	public void setValidTime(Date validTime) {
		this.validTime = validTime;
	}
	
	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
