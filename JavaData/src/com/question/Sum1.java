package com.question;

import java.util.Scanner;

//n的数字的和 1+2+3+4+5+...n
public class Sum1{
	
	int test(int n){
		if(n==1){
			return 1;
		}else{
			return test(n-1)+n;
		}
	}
	public static void main(String[] args) {
		Sum1 sum1=new Sum1();
		System.out.println("请输入你要求的和:");
		Scanner scanner=new Scanner(System.in);
		int m=scanner.nextInt();
		int s=sum1.test(m);
		System.out.println(s);
		
	}

}
