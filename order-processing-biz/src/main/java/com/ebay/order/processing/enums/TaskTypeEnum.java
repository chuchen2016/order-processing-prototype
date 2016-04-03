package com.ebay.order.processing.enums;

public enum TaskTypeEnum {
	
	PRE_EXECUTE((byte)0,(byte)1),
	
	EXECUTE((byte)1,(byte)2),
	
	POST_EXECUTE((byte)2,(byte)3),
	
	SUCCESS((byte)3,(byte)4),
	
	FAILED((byte)4,(byte)5);
	
	public Byte taskType;
	
	public Byte nextType;
    
    private TaskTypeEnum(Byte taskType,Byte nextType) {
        this.taskType = taskType;
        this.nextType = nextType;
    }	
    
    public static TaskTypeEnum getTaskByType(Byte type){
    	return null;
    }
	
}
