package com.java1995;

import java.util.Scanner;

public class TesetString {
	/*
	 * 输出时有""和无引号有区别有引号时为字符串；
	 * 无时为变量
	 */
	
	public static void main(String[]args){
		String mystring="hello word";
		System.out.println(mystring);
		System.out.println("mystring");
		String name="lukailei";
		String sex="man";
		String from="china";
		String information="我是："+name+" 性别："+sex+" 来自"+from;
		System.out.println(information);
//		测试String字符串的输入及应用
		System.out.println("请输入字符串：");
		Scanner scan=new Scanner(System.in);
		String str=scan.nextLine();
		scan.close();
		System.out.println(str);
		
	}

}
