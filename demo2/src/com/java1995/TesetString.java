package com.java1995;

import java.util.Scanner;

public class TesetString {
	/*
	 * ���ʱ��""��������������������ʱΪ�ַ�����
	 * ��ʱΪ����
	 */
	
	public static void main(String[]args){
		String mystring="hello word";
		System.out.println(mystring);
		System.out.println("mystring");
		String name="lukailei";
		String sex="man";
		String from="china";
		String information="���ǣ�"+name+" �Ա�"+sex+" ����"+from;
		System.out.println(information);
//		����String�ַ��������뼰Ӧ��
		System.out.println("�������ַ�����");
		Scanner scan=new Scanner(System.in);
		String str=scan.nextLine();
		scan.close();
		System.out.println(str);
		
	}

}
