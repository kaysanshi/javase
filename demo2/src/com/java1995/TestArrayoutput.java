package com.java1995;

public class TestArrayoutput {
	public static void main(String[] args) {
		int[] array1=new int[5];
		array1[0]=1;
		array1[1]=2;
		array1[2]=5;
		array1[3]=6;
		array1[4]=7;
		int[] array2={3,4,3,2,5};
		System.out.println("打印第一个数组");
		for(int i=0;i<5;i++){
			System.out.println(array1[i]);
		}
		System.out.println("第二个数组:");
		for(int j=0;j<5;j++){
			System.out.println(array2[j]);
		}
		int[][] n=new int[5][5];
		int[][] n1={{1,2,3},{4,5,6},{7,8,9}};
		for(int i=0;i<n.length;i++){
			for(int j=0;j<n1.length;j++){
				System.out.println(n1[i][j]);
			}
				}
				
	}

}
