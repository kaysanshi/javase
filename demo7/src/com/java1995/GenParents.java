package com.java1995;

public class GenParents<T> {
//	泛型类之间的继承演示
		//泛型类的无参构造；
	GenParents(){
		System.out.println("这是父类的无参构造方法：");
	}
//声明
	T t;
	GenParents(T t1){
		this.t=t1;
		System.out.println("这是父类的有参构造器得方法");
		System.out.println("T的类型："+t.getClass().getName());
	}
//	父类中的方法
	public void Print(){
		System.out.println("父类中的方法");
	}
}
