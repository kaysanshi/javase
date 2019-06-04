package com.java1995;

import java.util.Date;

public class TestStringRuntime {
	public static void main(String []args){
		Date d=new Date();
		System.out.println(d);
		String str ="";
//		正常的相加
		long starTime=System.currentTimeMillis();
		for(long i=0;i<100000;i++){
			str=str+i;
		}
		long endTime=System.currentTimeMillis();
		long time=endTime-starTime;
		System.out.println("String消耗的时间："+time);
		System.out.println(d);
//		方在StringBuilder()的方法是加入字符变并打印这个
		StringBuilder builder=new StringBuilder("");
		starTime=System.currentTimeMillis();
		for(long j=0;j<100000;j++){
		builder.append(j);
		}
		endTime=System.currentTimeMillis();
		time=endTime-starTime;
		System.out.println("String消耗的时间："+time);
 
//		StringtoString方法
//		先构建字符串生成器；
		StringBuilder builder1=new StringBuilder("HelloWord");
		String s=builder1.toString();//将字符串生成器转变为字符；
		System.out.println("s="+s);
		System.out.println("builder1="+builder1);
		
	}

}
