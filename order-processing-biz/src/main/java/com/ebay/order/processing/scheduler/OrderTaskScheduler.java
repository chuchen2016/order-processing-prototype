package com.ebay.order.processing.scheduler;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebay.order.processing.constants.SystemConstants;
import com.ebay.order.processing.execute.thread.OrderProcessingThread;
import com.ebay.order.processing.executor.OrderTaskExecutor;
import com.ebay.order.processing.factory.OrderTaskProcessExecutorFactory;
import com.ebay.order.processing.handler.OrderTaskConfigHandler;
import com.ebay.order.processing.handler.OrderTaskHandler;
import com.ebay.order.processing.model.dataObject.OrderTaskDO;

/**
 * 订单的scheduling阶段
 * @author chuchen
 *
 */
@Service("orderTaskScheduler")
public class OrderTaskScheduler implements InitializingBean,DisposableBean {
	
	@Autowired
	private OrderTaskHandler orderTaskHandler;
	
	@Autowired
	private OrderTaskConfigHandler orderTaskConfigHandler;
	
	//当前这台机器的标示
	private String key;
	
	@Autowired
	private OrderTaskProcessExecutorFactory orderTaskProcessExecutorFactory;
	
	private static Logger logger = Logger.getLogger(OrderTaskScheduler.class);
	
	static final ExecutorService taskPool = Executors.newFixedThreadPool(SystemConstants.THREAD_NUM);
	
	public void init() throws Exception {
		
		try{
			
           Runnable scheduleTask = new Runnable(){
			@Override
			public void run() {
				List<OrderTaskDO> tasks = orderTaskHandler.queryUnProcessedTask(key);
				for(OrderTaskDO task : tasks){
					OrderProcessingThread threadTask = new OrderProcessingThread();
					threadTask.setData(task);
					OrderTaskExecutor executor = orderTaskProcessExecutorFactory.getOrderProcessingThread(task.getType());
					threadTask.setOrderTaskExecutor(executor);
					//线程池,每台机器上开启50个线程
					taskPool.execute(threadTask);
				}
			}
           };
           
           //新开启一个线程来运行订单调度任务
           Thread scheduleThread = new Thread(scheduleTask);
           scheduleThread.start();
           
		}catch (Exception e){
			logger.error("init OrderTaskScheduler error",e);
		}
    }
	
	/**
	 * 该应用shutDown的时候将该机器从应用注册列表中移除
	 * 方便线上环境多台机器动态调度
	 * 不重复不遗漏的分配并且处理任务
	 */
	@Override
	public void destroy() throws Exception {
		
	}
	
	/**
	 * 该应用启动的时候注册该机器到应用注册列表中去
	 * 方便线上环境多台机器动态调度
	 * 不重复不遗漏的分配并且处理任务
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		register();
		key="mockUpValue";//一般是机器的IP地址
	}
	
	public void register(){
		orderTaskConfigHandler.register(key, DateUtils.addHours(new Date(), 5/*心跳时间:每五分钟注册一次否则算该节点宕机*/));
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
}
