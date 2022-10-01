package com.woomq.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * @author woo-mq
 * 随机数工具类
 */
public class RandomUtils {
	/**
	 * 当前时间+随机数
	 * @return
	 */
	public static String createActive(){
		
		return getTime()+Integer.toHexString(new Random().nextInt(900)+100);
	}

	/**
	 * 当前时间格式化
	 * @return
	 */
	public static String getTime(){
		return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime());
	}

	/**
	 * 生成随机顶点编号
	 * @return
	 */
	public static String createOrderId(){
		return getTime();
	}
}
