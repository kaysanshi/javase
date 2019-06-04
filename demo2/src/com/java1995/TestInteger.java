package com.java1995;

import java.util.Scanner;

public class TestInteger {
//未知意识 知识点不足：//猜箱与装箱；
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		String str=scan.nextLine();
		scan.close();
//		String p=new Integer(str);
		int a=Integer.parseInt(str);
		System.out.println(a);
	}

}
