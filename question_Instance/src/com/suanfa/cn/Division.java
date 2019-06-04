package com.suanfa.cn;

import java.util.Scanner;

//整数的划分;既是把一个整数划分为各个数的之和;
//算法出现问题;
public class Division {
	
	public String division(int n,int m){
		if(n<1||m<1){
			System.out.println("输入的有误");
		}else if (n==1||m==1){
			return 1+"";
		}else if(n<m){
			return this.division(n, n);
		}else if(n==m){
			return (1+"+"+this.division(n, n-1));
		}else{
			return (this.division(n, m-1)+"+"+this.division(n-m, m));
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println("输入你要划分的整数");
		int n=new Scanner(System.in).nextInt();
		Division division=new Division();
		System.out.println(division.division(n, n));
	}
}
