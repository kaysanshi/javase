package com.java1995;

public class TestArrayOfTwo3 {
	//����ļ� ���������Խ��ߵĺ�
	public static void main(String[] args) {
		int arr[][]={{1,2,3},{4,5,6},{7,8,9}};
		int sum=0;
		System.out.println("����arr[]��:");
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		for(int i=0;i<arr.length;i++){
			sum+=arr[i][i];
		}
		System.out.println("����arr[][]�ļ���:"+sum);
	}

}
