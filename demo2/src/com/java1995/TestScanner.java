package com.java1995;
import java.util.Scanner;

public class TestScanner {

	public static void main(String[] args) {
		System.out.println("请输入三个数据");
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		int b=scan.nextInt();
		int c=scan.nextInt();
		if(a>b){
			if(a>c){
				System.out.println("最大值为："+a);
			}
		}else if(b>c){
			if(c>a){
				System.out.println("最大值为："+b);
			}
			
		}else if(c>b){
			if(b>a){
				System.out.println("最大值为："+c);
			}
		}
		System.out.println("下面来求三个浮点型的最小值：");
		System.out.println("请分别输入三个数");
		float m=scan.nextFloat();
		float n=scan.nextFloat();
		float s=scan.nextFloat();
		scan.close();
		if(m<n){
			if(n<s){
				System.out.println("最小值为："+m);
			}
		}else if(n<s){
			if(s<m){
				System.out.println("最小值为："+n);
			}
		}else if(s<m){
			if(m<n){
				System.out.println("最小值为："+s);
			}
		}
		
		System.out.println("下面进行转换：");
		String str="123";
		int q=Integer.parseInt(str);//Integer类中的parseInt()可以将字符串转换为数字；
		System.out.println("字符串转换为数后"+q);
	}

}
