package com.mingribook;

import java.util.Scanner;

public class LeapYear {
//������жϣ�year%400==0||year%4==0&&year%100==0����Ҫ����
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("��������Ҫ�жϵ���ݣ�");
		long year=scan.nextLong();
		scan.close();
		if(year%400==0||year%4==0&&year%100==0){
			System.out.println(year+"�꣬������");
		}else{
			System.out.println(year+"�꣬��������");
		}
	}

}
