package com.java1995;

import java.util.Scanner;
//������ж�
public class LeapYear {
	
	public void judgeYear(int year){
		if(year%400==0||(year%4==0&&year%100!=0)){
			System.out.println(year+"������");
		}else{
			System.out.println(year+"��������");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("���������");
		LeapYear ly=new LeapYear();
		Scanner scan=new Scanner(System.in);
		int year=scan.nextInt();
		ly.judgeYear(year);
	}
}
