package com.java1995;

public class IntegerTest {
//integer 封装类
	public static void main(String[] args) {
//Integer类中的最大最小值
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		Integer p=new Integer("123");
		System.out.println("将 Integer的值作为double :"+p.doubleValue());
		System.out.println("将 Integer的值作为 int :"+p.intValue());
//		parseInt(String s) 
//		将字符串参数解析为带符号的十进制整数。
		int i=Integer.parseInt("123");
		System.out.println(i);
		int s=10;
		System.out.println("将十进制转换为二进制："+Integer.toBinaryString(s));
		System.out.println("将字符串表示为无符号十进制值。"+Integer.toUnsignedString(12));
//	下面进行测试自动装箱与拆箱
		Integer q2=new Integer("123");
		int q1=q2;
		System.out.println(q1);//拆箱
//		装箱
		int i1=4;
		Integer i2=i1;
		System.out.println(i2);

	}

}
