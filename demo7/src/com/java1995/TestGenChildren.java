package com.java1995;

public class TestGenChildren {

	public static void main(String[] args) {
		String s="java";
		GenChildren<String> gc=new GenChildren<String>(s);
		System.out.println(gc.t);
		Integer i=new Integer(100);
		GenChildren<Integer> g=new GenChildren<Integer>(i);
		System.out.println(g.t);
//		验证了重写成功
		g.Print();

	}

}
