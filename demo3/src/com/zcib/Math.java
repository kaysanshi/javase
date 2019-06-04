package com.zcib;

public class Math {
//	把所有的接口写到一个类中；
	public static void main(String[] args) {
		MMath p=new MMath();
		System.out.println("使用对象调用方法：");
		System.out.println(p.add(25, 10));
		System.out.println(p.jian(10, 4));
		System.out.println(p.cheng(25, 4));
		System.out.println(p.chu(10, 5));	
//		以下的调用是令一种的调用方法；
		Add padd=p;
		Jian mjian=p;
		Cheng mcheng=p;
		Chu mchu=p;
		System.out.println("使用接口类型的掉用：");
		System.out.println(padd.add(25,10));
		System.out.println(mjian.jian(10,4));
		System.out.println(mcheng.cheng(25,4));
		System.out.println(mchu.chu(10,5));
		
		
	}
}
/*
 * 
 */
	interface Add{
		int add(int a,int b);	
		}
	interface Jian{
		int jian(int a,int b);
	}
	interface Cheng{
		int cheng(int a,int b);
	}
	interface Chu{
		int chu(int a,int b);
	}

