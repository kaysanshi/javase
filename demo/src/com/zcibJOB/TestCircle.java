package com.zcibJOB;

public class TestCircle {

	public static void main(String[] args) {
		Circle p=new Circle();
		// 用this关键字方法；
		p.r =6;
		System.out.println(p.area(p.r));//面积
		System.out.println(p.perimeter(p.r));//周长；
		//用直接传参的方法；即方法中直接return，用直接传参；
		System.out.println(p.area(5));
		System.out.println(p.perimeter(5));
		//再次new出一个对象然后赋值；用this关键字的方法;
		Circle p1=new Circle();
		p1.r=6;
		System.out.println(p1.area(p1.r));

	}

}
