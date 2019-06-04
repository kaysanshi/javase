package com.java1995;

public class TestArrayOfTwo4 {
	//用foreach语句;用法：for(元素变量:遍历对象 obj){
//						引用了x的Java语句;}可以用来遍历一维和二维数组;
//在二维数组中应用时要先设置元素变量(int 新数组名1[]:数组名)先令数组名为遍历对象;
//然后在操作第一次设置的元素变量做为遍历对象即(int 新的数组名2:新数组名1);
	public static void main(String[] args) {
		int arr1[][]={{3,5,4},{2,6,7}};
		System.out.println("二维数组的元素:");
		for(int x[]:arr1){
			for(int e:x){
				System.out.print(e+" ");
			}
			System.out.println();
		}
	}
}
