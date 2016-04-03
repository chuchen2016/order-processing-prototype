package com.ebay.order.processing.model.dataObject;

import java.io.Serializable;
import java.util.Date;


public class OrderTaskConfigDO implements Serializable {
    
	private static final long serialVersionUID = 8359417797820814541L;

	private Long id;

    private String key;//暂时约定是机器的IP或者是机器的名称
    
    private Date validTime;//该段配置的有效时间,超过该有效时间的配置被认为为无效,任务调度程序不会再来读这个字段
    
    private Date createTime;//该条记录被写入数据库的时间
    
    private Date updateTime;//该条记录被更新的时间
    
    @Override
	public String toString() {
		return "OrderTaskConfigDO [id=" + id + ", key=" +
				key + ", validTime= "+validTime;
	}

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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
    
}