package com.java1995question;

import java.util.Scanner;

public class Test_Random {
//��������Ϸ��
	public static void main(String[] args) {
		System.out.println("�������Ϸ�����ڿ�ʼ");
		int x=(int)(Math.random()*100)+1;
		System.out.println("��������µ�����");
		Scanner scan=new Scanner(System.in);
		int i=1;
		while(i<=10){
		int input=scan.nextInt();
		if(input==x){
			System.out.println("��ϲ�����ˣ���");break;
		}else if(input>x){
			System.out.println("��µ����е��");
		}else if(input <x){
			System.out.println("��µ����е�С�ˣ�");
		}i++;
		if(i==10){
			System.out.println("��������汿������");
			System.out.println("�Ҳ��������ˣ�<�¸¸�>");break;
		}
		}
		
	}

}
