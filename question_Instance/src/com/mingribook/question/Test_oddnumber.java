package com.mingribook.question;

import java.util.Scanner;

public class Test_oddnumber {
//�ж���ż����
	public static void main(String[] args) {
		System.out.println("��������Ҫ�жϵ�������");
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		scan.close();
		if(a!=1&&a!=0){
			if(a%2==0){
				System.out.println(a+"��ż��");
			}else{
				System.out.println(a+"������");
				}
		}else{
			System.out.println(a+"�Ȳ�������Ҳ����ż��");
		}
	}

}
