package com.Java1995;

public class StaticInner {
//静态内部类的使用方法
	private static int age=12;
//	定义静态内部类
	static class In{
		static String name;
		public void print(){
			System.out.println(age);
		}
		public static void put(){
			System.out.println("静态内部类的静态方法");
		}
		public static void print1(String name){
			System.out.println(name);
		}
	}
}
