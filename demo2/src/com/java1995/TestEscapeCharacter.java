package com.java1995;

public class TestEscapeCharacter {
	public static void main(String[] args){
	String testStr="双引号\"单引号\'反斜杠\\下一行\n制表符\t回车\r";
	System.out.println(testStr);
	System.out.println(testStr.length());//测试长度；其中转义字符由两个字符组成编译器
	//会把他当成一个字符来编译；
	System.out.print(testStr);
	System.out.print(testStr.length());
	}
}
