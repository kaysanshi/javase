package com.Java1995;

public class OutClassTest {
	public static void main(String[] args) {
		OutClass out=new OutClass();
		out.getInner();
		System.out.println(out.i);//对比调用内部类的调用；
//		试图在测试类中创建内部类对象会报错；
//		Inner p1=new Inner();
//		但是如果确实要使用内部类时这时需要用以下方法；
		OutClass.Inner p1=out.new Inner(); 
		p1.put();
	}
	
}
