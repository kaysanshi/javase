package com.java1995;

public class TestArrayOfTwo3 {
	//求方阵的迹 即是求主对角线的和
	public static void main(String[] args) {
		int arr[][]={{1,2,3},{4,5,6},{7,8,9}};
		int sum=0;
		System.out.println("方阵arr[]是:");
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		for(int i=0;i<arr.length;i++){
			sum+=arr[i][i];
		}
		System.out.println("方阵arr[][]的迹是:"+sum);
	}

}
