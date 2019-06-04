package com.suanfa.cn;

import java.util.Scanner;

//交换i,和j;的值
public class Change {
	public void test(int i,int j){
		i=i*j;
		j=i/j;
		i=i/j;
		System.out.println("交换后的职位");
		System.out.println(i+","+j);
	}
	public static void main(String[] args) {
		Change change=new Change();
			Scanner scanner=new Scanner(System.in);
			int x=scanner.nextInt();
			int y=scanner.nextInt();
			change.test(x, y);
		}
}
