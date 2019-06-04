package com.java1995;

public class TestArraySort1 {
	//一维数组冒泡法排序
	public static void main(String[] args) {
		int[] array=new int[]{25,63,45,98,102,56,75};
		System.out.println("冒泡排序法的演示:");
		//输出冒泡法排序的过程
		for(int i=1;i<array.length;i++){
			for(int j=0;j<array.length-i;j++){
				if(array[j]>array[j+1]){
					int temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
				System.out.print(array[j]+" ");
			}
			System.out.print("【");
			for(int j=array.length-i;j<array.length;j++){
				System.out.print(array[j]+" ");
			}
			System.out.println("】");
			
		}
		//把排完序的数组输出
		System.out.println("冒泡法排序后的");
		for( int i=0;i<array.length;i++){

				System.out.print(array[i]+" ");
		}
	}
}
