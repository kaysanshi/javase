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
//			����쳣����׼������ջ��
			ex.printStackTrace();
//			ʹ��getMessage()��������쳣
			System.out.println(ex.getMessage());
//			ʹ��getLocalizedMessage()��������쳣
			System.out.println(ex.getLocalizedMessage());
			System.out.println(ex.toString());
		}
	}
	public static void main(String[] args) {
		Exception3 p=new Exception3();
		p.printBuginfo();
	}
}
