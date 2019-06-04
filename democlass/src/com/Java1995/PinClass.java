package com.Java1995;

public class PinClass {
//私有内部类
	private int age=12;
	private class In{
		public void print(){
			System.out.println(age);
		}
	}
//	外部类访问内部类中的方法的形式；
	public void outPrint(){
		In p=new In();
		p.print();
	}
}
