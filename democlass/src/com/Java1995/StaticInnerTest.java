package com.Java1995;

public class StaticInnerTest {
	public static void main(String[] args) {
//		静态内部类的调用方式
		StaticInner.In in=new StaticInner.In();
		in.print();
//		调用静态内部类的静态方法；
		StaticInner.In.put();
//		为静态内部类中的静态变量赋值
		StaticInner.In.name="10";
//		调用静态内部类的静态方法；
		StaticInner.In.print1(StaticInner.In.name);

	}

}
