package com.zcib.job;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestprintTime {

	public static void main(String[] args) {
//		获取当前时间 国际标准的
		Date time=new Date();
		System.out.println(time);
//		获取当前时间 中国式的；
		Date now=new Date();
		String s="北京时间：yyy年mm月dd日,E,HH:mm:ss";
		SimpleDateFormat f=new SimpleDateFormat(s);
		System.out.println(f.format(now));
	}

}
