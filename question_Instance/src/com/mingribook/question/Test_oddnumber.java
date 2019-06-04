package com.mingribook.question;

import java.util.Scanner;

public class Test_oddnumber {
//判断奇偶数；
	public static void main(String[] args) {
		System.out.println("请输入你要判断的整数：");
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		scan.close();
		if(a!=1&&a!=0){
			if(a%2==0){
				System.out.println(a+"是偶数");
			}else{
				System.out.println(a+"是奇数");
				}
		}else{
			System.out.println(a+"既不是奇数也不是偶数");
		}
	}

}
