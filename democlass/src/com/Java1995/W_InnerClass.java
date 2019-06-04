package com.Java1995;

public class W_InnerClass {
//方法内部类
	private int age =13;
	public void Print(  int x){
		class In{
			public void inPrint(){
				System.out.println(x);
				System.out.println(age);
			}
		}
//		外部类中的方法访问内部类对象
		In in=new In();
		in.inPrint();
	}
}
