package com.java1995;

import java.util.Date;

public class Date_Test {

	public static void main(String[] args) {
		Date time=new Date();
		System.out.println(time);
//		System.currentTimeMillis()当前的毫秒数
		System.out.println(new Date(System.currentTimeMillis()-2000000));
		Date time1=new Date(System.currentTimeMillis()+30000);
//		布尔类型的
		System.out.println(time.before(time1));

	}

}
