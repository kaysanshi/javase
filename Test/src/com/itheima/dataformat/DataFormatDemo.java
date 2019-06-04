package com.itheima.dataformat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import sun.print.resources.serviceui;

public class DataFormatDemo {
	/**
	 * 将日期对象转换 为不同的字符串形式，此时根据地区语言环境不同，转成不同的人
	 */
	public void test1(){
		Date date=new Date();
		DateFormat format=DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL,Locale.CHINA);
		String dateStr=format.format(date);
		System.out.println(dateStr);
		
	}
	/**
	 * @throws ParseException 
	 * 
	 */
	public void test2() throws ParseException{
		String daString="2010年1月25日 星期六 下午13时15分20秒 CST";
		DateFormat format=DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.CHINA);
		Date date=format.parse(daString);
		System.out.println(date.toLocaleString());
	}
	/**
	 * 9月~~10日##2013年**12时%20分%10秒
	 * @throws ParseException 
	 */
	
	public void test3() throws ParseException{
		String dateStr = "09月~~10日##2013年**12时%20分%10秒";
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM月~~dd日##yyyy年**HH时%mm分%ss秒");
		Date date = dateFormat.parse(dateStr);
		System.out.println(date.toLocaleString());
	}
	
	
	public void test4(){
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM月~~dd日##yyyy年**HH时%mm分%ss秒");
		String str = dateFormat.format(date);
		System.out.println(str);
	}
	
}
