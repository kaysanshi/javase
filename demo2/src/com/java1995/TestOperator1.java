package com.java1995;
/**
 * @author PC
 *使用i++;和++i的区别；联系一下c++和++c的区别
 */
public class TestOperator1 {
	public static void main(String[]args){
	int i=5;
		System.out.println("i="+i);//5
		System.out.println("i++="+i++);//5
		System.out.println("i="+i);//6
		System.out.println("++i="+ ++i);//7
		System.out.println("i="+i);//7
	
	}
}
