package com.Mingribook;

public class Exception3 {
//	
	public void printBuginfo(){
		try{
			int x=100;
			int y=0;
			int z=x/y;
			System.out.println(z);
		}catch(Exception  ex){
//			输出异常到标准错误流栈中
			ex.printStackTrace();
//			使用getMessage()方法输出异常
			System.out.println(ex.getMessage());
//			使用getLocalizedMessage()方法输出异常
			System.out.println(ex.getLocalizedMessage());
			System.out.println(ex.toString());
		}
	}
	public static void main(String[] args) {
		Exception3 p=new Exception3();
		p.printBuginfo();
	}
}
