package com.mingribook.question;

public class Test_I {
/*
 * problem:根据运行参数的个数决定循环打印变量i的值得次数；
 */
	int j;
	 static int count=0;
	static void getcanshu(int ... j){
//		System.out.println(j.length);参数的长度：
		for(int i=1;i<=j.length;i++){
			System.out.print(i+" ");
			count++;
		}	
		System.out.println("参数总共："+count+"个");
		count=0;
	}
	public static void main(String[] args) {
		getcanshu(2,3,3,444,4,4,5);
		getcanshu(1,2,4);
		getcanshu(2,35,8547,847,44);
	}

}
