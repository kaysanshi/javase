package com.java1995;

public class StringBuffer_Test {
	public static void main(String[] args) {
		StringBuffer sb=new StringBuffer("helloword");
//		��ȡָ���±������
		sb.charAt(5);
		System.out.println(sb.charAt(5));
//		ɾ����Ķ������������ַ�������ɾ������
		System.out.println(sb.deleteCharAt(3));
//		����װ��Ϊ��д��
		for(int i=0;i<sb.length();i++){
			char c=sb.charAt(i);
			c=(char)(c-32);
//		ָ�������е��ַ�������Ϊc��
			sb.setCharAt(i,c);
		}
		System.out.println(sb);
//		ͬ���Ƿ��ܹ�����str.tUpperCase();������
//		�������Ǹ�String�����вſ��Ե��������
		String s=new String("lukailei");
		System.out.println(s.toUpperCase());
	
	}

}
