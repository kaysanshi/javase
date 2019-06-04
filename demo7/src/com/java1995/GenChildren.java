package com.java1995;

public class GenChildren<T> extends GenParents<T> {
//	在子类中参数列表必须包含父类中的参数类型，子类的参数类型的参数列表可以有多个
		 GenChildren(T t){
			 super(t);
		System.out.println("泛型子类的构造方法");
	}
//		 子类重写父类的方法
		public void Print(){
			System.out.println("子类中的方法");
		}

}
