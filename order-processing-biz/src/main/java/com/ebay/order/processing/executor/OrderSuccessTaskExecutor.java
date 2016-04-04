package com.ebay.order.processing.executor;

import org.springframework.stereotype.Service;

import com.ebay.order.processing.model.dataObject.OrderTaskDO;


@Service("orderSuccessTaskExecutor")
public class OrderSuccessTaskExecutor extends OrderTaskExecutor {
	
	@Override
	public void execute(OrderTaskDO task) {
		//do post execute................
	}
	
}
