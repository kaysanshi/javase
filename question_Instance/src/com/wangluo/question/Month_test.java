package com.wangluo.question;

import java.util.Scanner;

public class Month_test {
//ͨ��������·��ж������Ǽ��·ݣ�
	public static void main(String[] args) {
		System.out.println("����������Ҫ�жϵ��·ݣ�");
		Scanner scan=new Scanner(System.in);
		String s=scan.nextLine();
		switch(s){
		case "1":
		case "12":
		case "2":
			System.out.println("����");break;
		case"3":
		case"4":
		case"5":
			System.out.println("����");break;
		case "6":
		case"7":
		case"8":
			System.out.println("�ļ�");break;
		case"9":
		case"10":
		case"11":
			System.out.println("�＾");break;
		default:System.out.println("������Ĳ��Ϸ�");break;
				
		}

	}

}
