package com.java1995;

public class TestArraySort {
	//数组排序1：使用直接插入排序法
	public static void main(String[] args) {
		int[] array=new int[]{20,40,90,30,60,70,50};
		System.out.println("排序前：");
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		int temp,j;
		for(int i=1;i<array.length;i++){
			temp=array[i];
			for(j=i-1;j>=0 && array[j]>temp;j--){
				array[j+1]=array[j];
			}
			array[j+1]=temp;
		}
		System.out.println("\n排序后：");
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}

}
