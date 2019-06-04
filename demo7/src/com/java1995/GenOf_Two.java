package com.java1995;

public class GenOf_Two <T,M>{
//	传入两个类型的参数在这里参数的类型可以是多个
	//属性
	T obj1;
	M obj2;
//	构造方法
	GenOf_Two(T i,M n){
		this.obj1=i;
		this.obj2=n;
	}
	public T getT(){
		return obj1;
	}
	public M getM(){
		return obj2;
	}
	public void show(){
		System.out.println(obj1.getClass().getName());
		System.out.println(obj2.getClass().getName());
	}

	public static void main(String[] args) {
		String s=new String("java ");
		Integer i=new Integer(1);
		GenOf_Two <String,Integer> s1=new GenOf_Two <String,Integer>(s,i);
		s1.show();
		System.out.println(s1.getM());
		System.out.println(s1.getT());
		//在参数化类型可以传入不同的或者相同的类型；
		System.out.println("传入相同类型的：");
		String s2=new String("move to your ");
		GenOf_Two<String ,String> x=new GenOf_Two<String,String>(s,s2);
		x.show();
		System.out.println(x.getT());
		System.out.println(x.getM());
		

	}

}
