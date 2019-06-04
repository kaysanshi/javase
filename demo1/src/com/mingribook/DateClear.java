package com.mingribook;

import java.util.Date;
import java.util.Locale;

public class DateClear {
//调用系统内部的 一些方式：
	public static void main(String[] args) {
		Date today=new Date();
		String a=String.format(Locale.US, "%tb", today);
		String b=String.format(Locale.US, "%tB", today);
		String c=String.format("%ta", today);//指定语言中的星期几的简称
		String d=String.format("%tA", today);//指定语言中的星期几的全称
		String e=String.format("%tY", today);//四位年份
		String f=String.format("%ty", today);//两位年份
		String g=String.format("%tm", today);//月份
		String h=String.format("%td", today);//一个月中的第几天
		String i=String.format("%te", today);//一个月中的某一天
		String k=String.format("%tc", today);//包括全部的日期和时间
		String l=String.format("%tj", today);//一年中的第几天
		System.out.println("格式化后的字符串的英文缩写："+a);
		System.out.println("格式化后的字符串的英文全写："+b);
		System.out.println("月格式化后的字符串为星期："+c);
		System.out.println("格式化后的字符串为星期："+d);
		System.out.println("格式化后的字符串为4位的年份值："+e);
		System.out.println("格式化后的字符串为4位的年份值："+f);
		System.out.println("格式化后的字符串为2位的月份值："+g);
		System.out.println("格式化后的字符串为2位的日期值："+h);
		System.out.println("格式化后的字符串为1位的日期值："+i);
		System.out.println("日期值："+k);
		System.out.println("当年中的第几天："+l);
	}

}
