package com.java1995;

public class TestArrayOfTwo2 {
	//m x n数组变为n x m数组
	public static void main(String[] args) {
		int arr[][]=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		System.out.println("原来的矩阵:");
		printArray(arr);//调用静态方法
		int arr2[][]=new int[arr.length][arr.length];
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				arr2[j][i]=arr[i][j];
			}
		}
		System.out.println("转换后的数组:");
		printArray(arr2);
	}
	//创建一个静态方法在主函数（main）中可以令主函数调用
	private static void printArray(int[][] arr) {
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
