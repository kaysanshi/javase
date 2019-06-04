package com.zcib;

public class TestCircle {
//	接口的实现；
	public static void main(String[] args) {
		Circle p=new Circle();
		System.out.println(p.getArea(5));
		System.out.println(p.getCircumference(5));
		Rectangle l=new Rectangle();
		System.out.println(l.getl(6,5));
		System.out.println(l.getArea(6,5));
	}

}
