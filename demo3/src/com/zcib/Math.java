package com.zcib;

public class Math {
//	�����еĽӿ�д��һ�����У�
	public static void main(String[] args) {
		MMath p=new MMath();
		System.out.println("ʹ�ö�����÷�����");
		System.out.println(p.add(25, 10));
		System.out.println(p.jian(10, 4));
		System.out.println(p.cheng(25, 4));
		System.out.println(p.chu(10, 5));	
//		���µĵ�������һ�ֵĵ��÷�����
		Add padd=p;
		Jian mjian=p;
		Cheng mcheng=p;
		Chu mchu=p;
		System.out.println("ʹ�ýӿ����͵ĵ��ã�");
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

