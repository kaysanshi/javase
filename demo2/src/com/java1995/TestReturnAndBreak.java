package com.java1995;

public class TestReturnAndBreak {
	//测试几个循环终止语句；
	public static void main(String[] args) {
		for(int i=0;i<=9;i++){
			if(i==5){
				//break;//终止本次循环，继续执行其他语句；
				return;//终止本次循环跳出方法体；不会执行其后的语句；
				//continue;//循环执行之后；继续执行其他语句；
			}
			System.out.println(i);
		}
		System.out.println("hello");
	}

}
