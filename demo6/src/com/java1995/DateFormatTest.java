package com.java1995;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatTest {
//Date 必须和DateFormat,两则一起用
	public static void main(String[] args) {
		Date date=new Date();
//		getInstance() 获取在日期和时间上使用SHORT样式的默认日期/时间格式化程序。 
		DateFormat df1=DateFormat.getInstance();
		System.out.println("抽象类的静态方法获得的实例："+df1.format(date));
//		下面是对他的格式的控制SimpleDateFormat是一个子类
		DateFormat df2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		DateFormat df3=new SimpleDateFormat("yyyy年MM月dd日hh时mm分ss秒");
		DateFormat df4=new SimpleDateFormat("yyy年MM月dd日");
		DateFormat df5=new SimpleDateFormat("yy年，MM月");
		DateFormat df6=new SimpleDateFormat("yyy年MMM");
		DateFormat df7=new SimpleDateFormat("hh:mm:ss");
		System.out.println(df2.format(date));
		System.out.println(df3.format(date));
		System.out.println("yyy年MM月dd日：："+df4.format(date));
		System.out.println("yy年，MM月：："+df5.format(date));
		System.out.println("yyy年MMM：："+df6.format(date));
		System.out.println(df7.format(date));
	}

}
