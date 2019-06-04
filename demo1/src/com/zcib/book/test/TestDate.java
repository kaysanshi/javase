package com.zcib.book.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestDate {
	public static void main(String[] args) {
		Date p=new Date();
		p.getTime();//
		System.out.println(p.getTime());
//date Format类
//		美式
//		 日期
		DateFormat df1=DateFormat.getDateInstance();
		String string=df1.format(new Date());
		System.out.println(string);
//		日期和时间一起显示精确到秒
		DateFormat df2=DateFormat.getDateTimeInstance();
		System.out.println(df2.format(new Date()));
//		中式
//		年日期
		DateFormat df3=DateFormat.getDateInstance(DateFormat.YEAR_FIELD,new Locale("zh","CN"));
		System.out.println(df3.format(new Date()));
//		年月日上下午秒
		DateFormat df4=DateFormat.getDateTimeInstance(DateFormat.YEAR_FIELD,DateFormat.ERA_FIELD,new Locale("zh","CN"));
		System.out.println(df4.format(new Date()));
//		simpleDateFormate类
		Date now=new Date();
		String s="北京时间：yyy年MM月dd日,E,HH:mm:ss";
		SimpleDateFormat f=new SimpleDateFormat(s);
		System.out.println(f.format(now));
	}
	
}

