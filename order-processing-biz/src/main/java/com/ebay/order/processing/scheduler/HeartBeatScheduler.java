package com.ebay.order.processing.scheduler;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebay.order.processing.constants.DateUtils;
import com.ebay.order.processing.factory.OrderTaskProcessExecutorFactory;
import com.ebay.order.processing.handler.OrderTaskConfigHandler;
import com.ebay.order.processing.handler.OrderTaskHandler;

/**
 * 维持心跳
 * 让整个系统得知该节点还存活
 * @author chuchen
 *
 **/

@Service("heartBeatScheduler")
public class HeartBeatScheduler {
	
	@Autowired
	private OrderTaskHandler orderTaskHandler;
	
	@Autowired
	private OrderTaskConfigHandler orderTaskConfigHandler;
	
	//当前这台机器的标示
	private String key;
	
	@Autowired
	private OrderTaskProcessExecutorFactory orderTaskProcessExecutorFactory;
	
	private static Logger logger = Logger.getLogger(HeartBeatScheduler.class);
	
	
	public void init() throws Exception {
		try{
			TimerTask heartBeatTask = new TimerTask(){
			@Override
			public void run() {
		        orderTaskConfigHandler.register(key, DateUtils.addMinutes(new Date(), 5/*心跳时间:每五分钟注册一次否则算该节点宕机*/));
			}
           };
           
           //新开启一个线程来运行订单调度任务
           Timer timer = new Timer();
           //五分钟后开始执行,每隔五分钟再执行一次
           timer.schedule(heartBeatTask, 1000*60*5/*5分钟*/, 1000*60*5/*5分钟*/);  
           
		}catch (Exception e){
			logger.error("init OrderTaskScheduler error",e);
		}
    }
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
}
