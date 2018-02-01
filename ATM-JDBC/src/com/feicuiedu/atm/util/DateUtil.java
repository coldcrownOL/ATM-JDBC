package com.feicuiedu.atm.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	/**
	 * 获取系统当前时间转成字符串 yyyyMMddHHmmssSSS
	 * @return 
	 */
	public static String dateToString() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String time = sdf.format(new Date());
        
        return time;
	}
	
	/**
	 * 获取系统当前时间转成字符串 yyyy-MM-dd HH:mm:ss
	 */
	public static Date date() {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(date);
		Timestamp tt = Timestamp.valueOf(time);
		
		return tt;
	}
	
}
