package com.java1995;

public class TestForStatement {
	public static void main(String[] args) {
		int sum=0;
		for(int i=2;i<=100;i+=2){
			sum+=i;
		}
		System.out.println("2到200之间的偶数的和："+sum);
	}

}
