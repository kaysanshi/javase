package com.mingribook.question;

public class Test_arrays_sum {
//����һ����ά���齫��ά��������Ԫ�صĺ������
	public static void main(String[] args) {
		int arr[][]=new int[][]{{1,2},{3,4},{5,6},{7,8},{9,10}};
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();	
		}
		System.out.println("�����е�Ԫ�صĺͣ�");
		int sum=0;
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				sum+=arr[i][j];
			}
		}
		System.out.println(sum);
		System.out.println("�ڶ��ַ������㣺");
		for(int x[]:arr){
			for(int e:x){
				System.out.print(e+" ");
			}
			System.out.println();
		}
		System.out.println("�õڶ��ַ��������:");
		int sum1=0;
		for(int x[]:arr){
			for(int e:x){
				sum1+=e;
				}
			}
		System.out.println(sum1);
	}

}
