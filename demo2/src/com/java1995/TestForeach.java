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
//		以下是foreach对int类型中的数组的存放
		System.out.println("以下是对int类型中的数组的存放：");
		Random rand1=new Random(30);
		int a[]=new int[10];
		for(int i=0;i<10;i++)
			a[i]=rand1.nextInt(100);//在此控制要参生随机数的区域；
		for(int m:a){
			System.out.println(m);
		}
//		对比for循环的类型和foreach的不同；
		for(int i=0;i<10;i++){
			System.out.println(a[i]);
		}

	}

}
