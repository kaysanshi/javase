package com.java1995question;

import java.util.Scanner;

public class Instance8 {
//	????????????????????????
//	�����ڿ���̨����һ���ַ���
//	Ȼ���ڿ���̨�����Ӵ�
//	�����Ӵ����ֵĴ���
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		System.out.println("������һ���ַ���");
		String s=scan.nextLine();
		System.out.println("������һ���Ӵ���");
		String s1=scan.nextLine();
		int count=0;
		if(s.equals(null)||s1.equals(null)){
			System.out.println("û�п�ƥ����Ӵ�");
		}else{
			for(int i=0;i<s.length();i++){
				System.out.println(s.substring(i));
				System.out.println("��ʽ��"+s.substring(0, i+1));
				if(s1.equals(s.substring(i))||s1.equals(s.substring( 0, i+1))){
					count++;
				}
				}
			}
			System.out.println(count);
		}
}
