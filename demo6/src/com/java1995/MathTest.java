package com.java1995;

public class MathTest {

	public static void main(String[] args) {
//		����ȡ����
		double d=Math.ceil(22.2);
		System.out.println(d);
//		����ȡ����
		double m=Math.floor(22.2);
		System.out.println(m);
		System.out.println("���ز����ͣ�"+Math.addExact(5, 6));
//		Math.random()����ֵΪ doubleֵΪ���ţ����ڵ��� 0.0 ��С�� 1.0 �� 
		System.out.println(Math.random());
//		multiplyExact(long/int x, long/int y) 
//		���ز����ĳ˻������������long�����׳� long 
		System.out.println(Math.multiplyExact(9, 8));
	}

}
