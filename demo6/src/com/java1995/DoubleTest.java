package com.java1995;

public class DoubleTest {
//	��װ����ԣ�
	public static void main(String[] args) {
//		double �����ֵ����Сֵ
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);
		double b=Double.parseDouble("123");
		System.out.println(b);
		System.out.println("�㶨����double�͵��������"+Double.MAX_EXPONENT);
		System.out.println("�㶨����double�͵ĸ������"+Double.MIN_EXPONENT);
		Double d=new Double("123");
		System.out.print(d.doubleValue()+","+d.floatValue());
	}
}
