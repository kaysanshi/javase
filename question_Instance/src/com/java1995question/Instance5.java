package com.java1995question;

import java.util.Scanner;

public class Instance5 {
//���õ���������ʵ���������Ľ���
	public static void main(String[] args) {
		int a=100;
		int b=10;
		a=a*b;
		b=a/b;
		a=a/b;
		System.out.println("a="+a+"b="+b);
		System.out.println("������Ҫ����������");
		Scanner scan=new Scanner(System.in);
		int m=scan.nextInt();
		int n=scan.nextInt();
		m=m*n;
		n=m/n;
		m=m/n;
		scan.close();
		System.out.println("�����������Ϊ:m="+m+",n="+n);
	}

}
