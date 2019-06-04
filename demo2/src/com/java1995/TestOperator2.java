package com.java1995;

public class TestOperator2 {
	/*public static boolean returntrue(){
		return true;//定义了一个方法可以让其他语句调用   
	}*/
	public static void main(String[] args){
		int a=5;
		int b=10;//不定义布尔类型时用的是布尔类型的值
		boolean flage=a>b;//布尔类型的变量
		if(/*returntrue()*/flage){
			System.out.println("a>b");
			}
			else {
				System.out.println("a<=b");
			}
			
	}

}
