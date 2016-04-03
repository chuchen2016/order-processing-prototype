package com.ebay.order.processing.enums;

public enum TaskStatusEnum {

	//当前该任务的处理状态 
	//0: 未执行,
	//1:处理中,
	//2:处理成功,
	//3:处理异常
	UNEXECUTED((byte)0),
	
	EXECUTING((byte)1),
	
	SUCCESS((byte)2),
	
	FAILURE((byte)3);
	
	public Byte status;
	
	private TaskStatusEnum(Byte status) {
        this.status = status;
    }	
	
}
