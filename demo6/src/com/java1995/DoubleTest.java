package com.java1995;

public class DoubleTest {
//	封装类测试：
	public static void main(String[] args) {
//		double 的最大值与最小值
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);
		double b=Double.parseDouble("123");
		System.out.println(b);
		System.out.println("恒定持有double型的正无穷大："+Double.MAX_EXPONENT);
		System.out.println("恒定持有double型的负无穷大："+Double.MIN_EXPONENT);
		Double d=new Double("123");
		System.out.print(d.doubleValue()+","+d.floatValue());
	}
}
