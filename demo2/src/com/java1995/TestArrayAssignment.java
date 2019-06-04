package com.java1995;

public class TestArrayAssignment {
	//测试数组的初始化方式和复制
	public static void main(String[] args) {
		int[] array1={1,2,5};
		int[] array2={7,8,9};
		System.out.println("数组初始化为：");
		//(数组名+.length)可以检测数组的长度；
		for(int i=0;i<array1.length;i++){
			System.out.println("array1["+i+"]="+array1[i]);
			}
			for(int j=0;j<array2.length;j++){
				System.out.println("array2["+j+"]="+array2[j]);
		}
		//把array2赋值给array1；即复制； 
			array1=array2;//其实是把array1的首地址指向了array2的首地址
			System.out.println("数组赋值后：输出数组一和二");
			for(int i=0;i<array1.length;i++){
				System.out.println("array1["+i+"]="+array1[i]);
				}
			for(int j=0;j<array2.length;j++){
				System.out.println("array2["+j+"]="+array2[j]);
			}
			//改动数组的值后再进行操作；因前面对数组复制了 ；且复制后无论改变哪个数组
			//中的值则原先复制过的数组中的值都会改变
			array1[0]=100;
			array1[1]=200;
			array2[1]=130;
			System.out.println("array重新复制后的数组：");
			for(int i=0;i<array1.length;i++){
				System.out.println("array1["+i+"]="+array1[i]);
				}
			for(int j=0;j<array2.length;j++){
				System.out.println("array2["+j+"]="+array2[j]);
			}
	}
}
