package com.java1995;

import java.util.Scanner;

//���
public class Sum {
	int sum=0;
	public int addSum(int a){
		for(int i=0;i<=a;i++){
			sum+=i;
		}
		return sum;
	}
	public static void main(String[] args) {
		System.out.println("��������͵�����");
		Sum s=new Sum();
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		scan.close();
		System.out.println(s.addSum(a));
	}

}
