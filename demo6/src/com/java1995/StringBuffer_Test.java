package com.java1995;

public class StringBuffer_Test {
	public static void main(String[] args) {
		StringBuffer sb=new StringBuffer("helloword");
//		获取指定下标的数字
		sb.charAt(5);
		System.out.println(sb.charAt(5));
//		删除后的都输出，下面的字符串都是删除过了
		System.out.println(sb.deleteCharAt(3));
//		将其装换为大写的
		for(int i=0;i<sb.length();i++){
			char c=sb.charAt(i);
			c=(char)(c-32);
//		指定索引中的字符被设置为c。
			sb.setCharAt(i,c);
		}
		System.out.println(sb);
//		同样是否能够调用str.tUpperCase();方法呢
//		不能在那个String方法中才可以调用这个：
		String s=new String("lukailei");
		System.out.println(s.toUpperCase());
	
	}

}
