package com.java1995;

import java.util.Date;

public class StringBufferTime {
//	测试二则的加载运行时间
	public static void main(String[] args) {
		System.out.println(new Date());
		String s="";
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<10000;i++){
			sb.append(i);
		}
		System.out.println(new Date());
//		String 类的测试；
		
		System.out.println("测试String加载的时间");
		for(int i=0;i<10000;i++){
			s+=i;
		}
		System.out.println(new Date());
	}

}
