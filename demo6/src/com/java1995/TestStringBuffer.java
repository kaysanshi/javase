package com.java1995;

public class TestStringBuffer {

	public static void main(String[] args) {
//		StringBuffer 三种构造方法
		StringBuffer sb=new StringBuffer();
//		capacity()返回当前的容量大小
		System.out.println(sb.capacity());
		StringBuffer sb1=new StringBuffer("abc");
		System.out.println(sb1.capacity());
//		这是进行传值将 int参数的字符串表示附加到此序列。
		StringBuffer sb2=new StringBuffer(1000);
		System.out.println(sb2.capacity());
//		采用这个方法进行传入字符及其拼接
		StringBuffer sb3=new StringBuffer("hello");
		sb3.append("every body"+"\n");
		sb3.append("you must ");
		sb3.append("come on!!!");
//		将创建的StringBuffer()引用再次加入到序列中
		sb3.append(sb1);
//		输出的方法是：
		System.out.println(sb3.toString());
		
	}

}
