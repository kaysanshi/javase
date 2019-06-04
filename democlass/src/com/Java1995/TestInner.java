package com.Java1995;

public class TestInner {
	public static void main(String[] args) {
//	匿名内部类可以实现父类和接口的调用；
		Out1 out=new Out1(){
			@Override
			public void show() {
					System.out.println("这是匿名内部类的使用");
			}
			
		};
		out.show();
//		在此调用父类应如何掉用呢用匿名内部类的形式？？？
//		Parents p=new Parents(){
//			
//			public void eat(){
//				
//			}
//		};
	}
	
//	接口
	interface Out1{
		public void show();
	}
	class Out2 implements Out1{

		@Override
		public void show() {
			// TODO Auto-generated method stub
		}
		
	}
//	定义一个父类
	class Parents{
		public void eat(){
			System.out.println("父类中的方法的实现");
		}
	}
	class Chirlden extends Parents{}
}
