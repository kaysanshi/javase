package com.gjp.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {
	
	public static int getYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}
	
	public static String firstdayByYear() {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		return year + "-01-01";
	}
	
	
	public static String lastdayByYear() {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		return year + "-12-31";
	}	
	
	
	public static java.sql.Date toSQLDate(String str) {
		return new java.sql.Date(string2Date(str).getTime());
	}
	
	
	public static String today() {
		return date2String(new java.util.Date());
	}
	
	
	public static String date2String(java.util.Date date) {
		return String.format("%tF", date);
	}
	
	
	public static java.util.Date string2Date(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			throw new RuntimeException("鏃ユ湡瀛楃鏍煎紡閿欒锛�" + str);
		}
	}
	
	
	public static java.util.Date getFirstDayOfMethod() {
		Calendar c = Calendar.getInstance();//鑾峰彇褰撳墠鏃ユ湡瀵硅薄
		c.set(Calendar.DAY_OF_MONTH, 1);//璁剧疆鏃ユ湡涓�1
		return c.getTime();
	}
	
	public static java.util.Date getLastDayOfMethod() {
		Calendar c = Calendar.getInstance();//鑾峰彇褰撳墠鏃ユ湡瀵硅薄
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));//璁剧疆鏃ユ湡涓�1
		return c.getTime();
	}
}
