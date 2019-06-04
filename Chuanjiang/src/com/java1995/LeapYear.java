package com.java1995;

import java.util.Scanner;
//闰年的判断
public class LeapYear {
	
	public void judgeYear(int year){
		if(year%400==0||(year%4==0&&year%100!=0)){
			System.out.println(year+"是闰年");
		}else{
			System.out.println(year+"不是闰年");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("请输入年份");
		LeapYear ly=new LeapYear();
		Scanner scan=new Scanner(System.in);
		int year=scan.nextInt();
		ly.judgeYear(year);
	}
}
