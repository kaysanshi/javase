package com.java1995;

public class Exception1 {
	public static void main(String[] args) {
		
	
	try{
		int c=3/0;
		System.out.println(c);
	}catch(ArithmeticException e){
		System.out.println("程序异常");
//		输出栈的信息
		e.getStackTrace();
		System.out.println(e.getMessage());
		}
	}
}
