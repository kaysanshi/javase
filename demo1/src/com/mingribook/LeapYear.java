package com.mingribook;

import java.util.Scanner;

public class LeapYear {
//闰年的判断：year%400==0||year%4==0&&year%100==0；主要核心
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入你要判断的年份：");
		long year=scan.nextLong();
		scan.close();
		if(year%400==0||year%4==0&&year%100==0){
			System.out.println(year+"年，是闰年");
		}else{
			System.out.println(year+"年，不是闰年");
		}
	}

}
