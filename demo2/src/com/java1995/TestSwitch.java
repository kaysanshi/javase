package com.java1995;
import java.util.Scanner;
public class TestSwitch {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("���������ڼ���");
		int i=scan.nextInt();
		scan.close();
		//int i=5;
		switch(i) {
			case 1:System.out.println("����һ");break;
			case 2:System.out.println("���ڶ�");break;
			case 3:System.out.println("������");break;
			case 4:System.out.println("������");break;
			case 5:System.out.println("������");break;
			case 6:System.out.println("������");break;
			case 7:System.out.println("������");break;
		default:System.out.println("���ֲ��Ϸ�");break;
		}
	}

}