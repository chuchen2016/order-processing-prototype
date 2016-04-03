package com.ebay.order.processing.constants;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static Date addMinutes(Date time,Integer minutesCount){
		Calendar calendar=Calendar.getInstance();   
		calendar.setTime(time); 
		calendar.set(Calendar.MINUTE,calendar.get(Calendar.MINUTE)+minutesCount);//让日期加1 
		return calendar.getTime();
	}
	

}