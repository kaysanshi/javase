package com.zcibJOB;

import java.util.Scanner;

public class Eg6 {
//	���򲻿����У�
	public void array(int x){
		int a[]=new int[x];
		Scanner scan=new Scanner(System.in);
		System.out.println("���������Ԫ�أ�");
		for(int i=0;i<a.length;i++){
			 a[i]= scan.nextInt();
		}
		scan.close();
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}
}
