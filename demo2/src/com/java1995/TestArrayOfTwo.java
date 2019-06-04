package com.java1995;

public class TestArrayOfTwo {
	public static void main(String[]args){
		//int[][] n=new int[5][5];
		int[][] n1={{1,2,3},{4,5,6},{7,8,9}};
		for(int i=0;i<n1.length;i++){
			for(int j=0;j<n1[i].length;j++){
				System.out.print(n1[i][j]);
			}
			System.out.println();
		}
	}
}
