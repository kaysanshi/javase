package com.java1995;

public class Tiger extends Animal {
//	子类中的可以继承父类的方法也可以重写父类的方法；
//	子类也可以有自己的新的方法；
	public void eat(){
		System.out.println("老虎在吃东西");
	}
	public void run(){
		System.out.println("老虎在奔跑");
	}
}
