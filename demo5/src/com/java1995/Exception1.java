package com.java1995;

public class Exception1 {
	public static void main(String[] args) {
		
	
	try{
		int c=3/0;
		System.out.println(c);
	}catch(ArithmeticException e){
		System.out.println("�����쳣");
//		���ջ����Ϣ
		e.getStackTrace();
		System.out.println(e.getMessage());
		}
	}
}
