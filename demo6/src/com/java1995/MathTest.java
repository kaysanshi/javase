package com.java1995;

public class MathTest {

	public static void main(String[] args) {
//		向上取整，
		double d=Math.ceil(22.2);
		System.out.println(d);
//		向下取整，
		double m=Math.floor(22.2);
		System.out.println(m);
		System.out.println("返回参数和："+Math.addExact(5, 6));
//		Math.random()返回值为 double值为正号，大于等于 0.0 ，小于 1.0 。 
		System.out.println(Math.random());
//		multiplyExact(long/int x, long/int y) 
//		返回参数的乘积，如果结果溢出long，则抛出 long 
		System.out.println(Math.multiplyExact(9, 8));
	}

}
