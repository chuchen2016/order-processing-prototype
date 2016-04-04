package com.ebay.order.processing.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebay.order.processing.handler.OrderTaskHandler;
import com.ebay.order.processing.model.dataObject.OrderTaskDO;

@Service("orderPreviewTaskExecutor")
public class OrderPreviewTaskExecutor extends OrderTaskExecutor {
	
	@Autowired
	OrderTaskHandler orderTaskHandler;
	
	@Override
	public void execute(OrderTaskDO task) {
		//do post execute................
	}
}
