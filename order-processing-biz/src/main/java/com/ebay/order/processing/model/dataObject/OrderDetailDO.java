package com.ebay.order.processing.model.dataObject;

import java.util.Date;

import lombok.Data;


@Data
public class OrderDetailDO {
    
    private Integer id;

    private Integer orderId;
    
    private Date createTime;
    
    private Date updateTime;
    
    private Double price;
    
    private String detail;
    
    @Override
	public String toString() {
		return "OrderTaskDO [id=" + id + ", orderId=" +
				orderId + ", price=" + price + ", createTime=" +
				createTime + ", updateTime="+updateTime + ",detail="+detail;
	}
}