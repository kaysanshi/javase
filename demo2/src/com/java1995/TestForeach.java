package com.java1995;

import java.util.Random;

public class TestForeach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random rand =new Random(47);
		float f[]=new float[10];
		for(int i=0;i<10;i++){
			f[i]=rand.nextFloat();
		}
		for(float x:f){
			System.out.println(x);
		}
//		������foreach��int�����е�����Ĵ��
		System.out.println("�����Ƕ�int�����е�����Ĵ�ţ�");
		Random rand1=new Random(30);
		int a[]=new int[10];
		for(int i=0;i<10;i++)
			a[i]=rand1.nextInt(100);//�ڴ˿���Ҫ���������������
		for(int m:a){
			System.out.println(m);
		}
//		�Ա�forѭ�������ͺ�foreach�Ĳ�ͬ��
		for(int i=0;i<10;i++){
			System.out.println(a[i]);
		}

	}

}
