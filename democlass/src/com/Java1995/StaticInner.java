package com.Java1995;

public class StaticInner {
//��̬�ڲ����ʹ�÷���
	private static int age=12;
//	���徲̬�ڲ���
	static class In{
		static String name;
		public void print(){
			System.out.println(age);
		}
		public static void put(){
			System.out.println("��̬�ڲ���ľ�̬����");
		}
		public static void print1(String name){
			System.out.println(name);
		}
	}
}
