package com.mingribook;

public class OutClass {
//	起先是在外部类实例化内部类的引用变量
	innerClass in=new innerClass();
	public void ouf(){
		System.out.println("外部类中的方法中调用内部类的方法：");
		in.inf();
	}
//	定义一个内部类；
	class innerClass{
		innerClass(){
			System.out.println("这是内部类的构造方法；");
		}
		public void inf(){
			System.out.println("这是内部类的方法：");
		}
		int y=0;
	}
//	外部类方法；
	public innerClass doit(){
		in.y=4;
		return new innerClass();
	}
	

	public static void main(String[] args) {
		OutClass out=new OutClass();
//		内部类的对象实例化操作必须在外部类或外部类中的非静态方法中实现；
		OutClass.innerClass in=out.doit();

	}

}
