package com.java1995;

public class Trycatchfinally {
	public static void main(String[] args) {
		double a=Math.random();
		try{
			if(a>0.5){
				System.out.println(a+"���򲻱���");
			}else{
				throw new Exception();
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println("�����ⲿ���׳����쳣"+e);
			try{
				a=1/0;
			}catch(ArithmeticException e1){
				System.out.println("�����ڲ��"+e1);
			}finally{
				System.out.println("�����ڲ��finally");
			}
		}finally{
			System.out.println("��������finally");
		}
	}
}
