package com.ebay.order.processing.executor;

import org.springframework.beans.factory.annotation.Autowired;

import com.ebay.order.processing.enums.TaskStatusEnum;
import com.ebay.order.processing.handler.OrderTaskHandler;
import com.ebay.order.processing.model.dataObject.OrderTaskDO;

/**
 * 任务执行处理器
 * @author chuchen
 *
 **/
public abstract class OrderTaskExecutor {
	
	@Autowired
	protected OrderTaskHandler orderTaskHandler;
	
	public abstract void execute(OrderTaskDO task);
	
	public void onSuccess(OrderTaskDO task) {
		task.setCount(task.getCount() + 1);
		task.setStatus(TaskStatusEnum.SUCCESS.status);
		orderTaskHandler.updateOrderTask(task, task.getOrderId(), task.getStep());
	}

	public void onFailure(OrderTaskDO task) {
		if(task.getCount() < 5){
			//修改任务执行次数;修改成未执行,进而被任务调度器重试
			task.setCount(task.getCount() + 1);
			task.setStatus(TaskStatusEnum.UNEXECUTED.status);
			orderTaskHandler.updateOrderTask(task, task.getOrderId(), task.getStep());
		}else{
			//不再重试了,直接标注为失败
			task.setStatus(TaskStatusEnum.FAILURE.status);
			orderTaskHandler.updateOrderTask(task, task.getOrderId(), task.getStep());
			//do something rollback...................
		}
	}
	
}
