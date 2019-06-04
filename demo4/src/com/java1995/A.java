package com.java1995;

public class A {
	A(){
		System.out.println("调用无参的A()");
	}
	A(int i){
		System.out.println("调用有参的A()");
	}
}
class B extends A{
		B(){
			System.out.println("调用无参的B()");
		}
		B(int i){
			super(i);//在此用super关键字来掉用父类中有参的构造方法
			System.out.println("调用有参的B()");
		}
	}
class C extends B{
		C(){
			super();//此句为默认的调用不需要显现出来编译器会自动加上；
			System.out.println("调用无参的C()");
		}
		C(int i){
			super(i);
			System.out.println("调用无参的C()");
		}
	}

