package com.java1995;

public class TestEscapeCharacter {
	public static void main(String[] args){
	String testStr="˫����\"������\'��б��\\��һ��\n�Ʊ��\t�س�\r";
	System.out.println(testStr);
	System.out.println(testStr.length());//���Գ��ȣ�����ת���ַ��������ַ���ɱ�����
	//���������һ���ַ������룻
	System.out.print(testStr);
	System.out.print(testStr.length());
	}
}
