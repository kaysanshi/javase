package com.java1995question;
/*
 * 用实例来测试输入接收流；
 */
import java.util. Scanner;
public class Instance4 {
	public static void main(String[] args) {
		System.out.println("判断三个数中的大的数：");
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		int b=scan.nextInt();
		int c=scan.nextInt();
		scan.close();
		System.out.println();
		if(a>b){
			System.out.println(a);
		}
		else if(a>c){
			System.out.println(a);
		}
		else if(b>c){
			System.out.println(b);
		}
		else {
		System.out.println(c);
		}
	}

}
