package com.Mingribook;

public class Exception5 {
//	测试异常；可控式；
	 int num=60;
	public int setNum(int num){
		this.num=num;
		return num;
	}
//	类的构造方法
	public Exception5(){
		try{
			Class.forName("com.mingribook.Test");//装载这个类
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		System.out.println("测试：");
	}
	public static void main(String[] args) {
		Exception5 p=new Exception5();
		p.setNum(1258);
		System.out.println(p.setNum(1258));
	}

}
