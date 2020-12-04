package com.question;

import java.util.Scanner;

// 完数是一个数等于除其自身外的因子之和，例如6=1+2+3，则6就是完数
public class Wanshu {
	public void test(int n){
		int s,j;
		int a[]=new int[2000];//定义一个数组;
		for(int i=1;i<=n;i++){
			int k=0;s=1;
			for(j=2;j<i;j++){
				if(i%j==0){
					s+=j;//
					a[k]=j;//
					k++;
				}
				}
				if(i==s){
					System.out.print( s+" it is:"+1);
					for(j=0;j<k;j++){
						System.out.print(" "+a[j]);
					}
					System.out.println();
				}
			
		}
	}
	public static void main(String[] args) {
		Wanshu w=new Wanshu();
		Scanner scanner=new Scanner(System.in);
		int x=scanner.nextInt();
		w.test(x);
	}
}
