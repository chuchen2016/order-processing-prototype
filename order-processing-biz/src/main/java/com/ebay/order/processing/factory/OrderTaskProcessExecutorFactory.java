package com.ebay.order.processing.factory;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.ebay.order.processing.enums.TaskTypeEnum;
import com.ebay.order.processing.executor.OrderTaskExecutor;

@Service("orderTaskProcessThreadFactory")
public class OrderTaskProcessExecutorFactory implements InitializingBean {
	
	@Resource(name="orderPreviewTaskExecutor")
	OrderTaskExecutor orderPreviewTaskExecutor;
	
	@Resource(name="orderProcessTaskExecutor")
	OrderTaskExecutor orderProcessTaskExecutor;
	
	@Resource(name="orderSuccessTaskExecutor")
	OrderTaskExecutor orderSuccessTaskExecutor;
	
	@Resource(name="orderPostTaskExecutor")
	OrderTaskExecutor orderPostTaskExecutor;
	
	@Resource(name="orderFailureTaskExecutor")
	OrderTaskExecutor orderFailureTaskExecutor;
	
	/**
	 * 这里有点土,可以有更优雅的做法
	 * @param type
	 * @return
	 */
	public OrderTaskExecutor getOrderProcessingThread(Byte type){
		if(type == null){
			return null;
		}
		if(type == TaskTypeEnum.PRE_EXECUTE.taskType)
			return orderPreviewTaskExecutor;
		if(type == TaskTypeEnum.EXECUTE.taskType)
			return orderProcessTaskExecutor;
		if(type == TaskTypeEnum.POST_EXECUTE.taskType)
			return orderPostTaskExecutor;
		if(type == TaskTypeEnum.SUCCESS.taskType)
			return orderPostTaskExecutor;
		if(type == TaskTypeEnum.FAILED.taskType)
			return orderPostTaskExecutor;
		return null;
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
	
	
}
