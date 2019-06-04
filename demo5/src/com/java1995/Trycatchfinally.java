package com.java1995;

public class Trycatchfinally {
	public static void main(String[] args) {
		double a=Math.random();
		try{
			if(a>0.5){
				System.out.println(a+"程序不报错");
			}else{
				throw new Exception();
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println("这是外部的抛出的异常"+e);
			try{
				a=1/0;
			}catch(ArithmeticException e1){
				System.out.println("这是内层的"+e1);
			}finally{
				System.out.println("这是内层的finally");
			}
		}finally{
			System.out.println("这是外层的finally");
		}
	}
}
