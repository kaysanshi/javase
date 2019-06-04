package com.java1995;

import java.util.Arrays;

public class TestArray1 {
//填充替换数组的元素;1.fill(int[]a,int value)方法;用于空白数组的填充,分配这个类型的数组的每一个元素;
//2.fill(int[]a,int fromindex,toindex,int value)方法;用于数组的指定替换范围内替换,含前不含后;
	public static void main(String[] args) {
		int arr[]=new int[5];
		Arrays.fill(arr,5);//空白数组的填充
		for(int i=0;i<arr.length;i++){
			System.out.println("第"+(i+1)+"个元素是:"+arr[i]);
		}
		System.out.println("第二种替换方法:");
		int array[]=new int[]{45,12,2,10,1};
		Arrays.fill(array,1,3,6);//插入式替换不包括前
		for( int j=0;j<array.length;j++){
			System.out.println("第"+j+"个元素是:"+array[j]);
		}
	}
}
