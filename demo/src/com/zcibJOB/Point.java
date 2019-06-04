package com.zcibJOB;   
import java.util.Random;

public class Point {
//	利用随机函数定义10对(x,y)值，由此创建的Point类实例存入一个数组中
//	按与原点（0，0）的距离由小到大的顺序输出所有的点及到原点的距离。
	//产生随机数的方法；
	static int x=new Random().nextInt(30);
	static int y=new Random().nextInt(30);
	public static void main(String[]args){
		int arr[]=new int[10];
		System.out.println("x的随机坐标为：");
		for(int i=0;i<arr.length;i++){
			int x=new Random().nextInt(30);
			System.out.println(x);
		}
		System.out.println("y的随机坐标为：");
		for(int i=0;i<arr.length;i++){
			int y=new Random().nextInt(30);
			System.out.println(y);
		}
		System.out.println("(x ,y) 的坐标是:");
		for(int i=0;i<arr.length;i++){
			int x=new Random().nextInt(30);
			int y=new Random().nextInt(30);
			System.out.print("("+x+",");
			System.out.println(y+")");
			double m=x*+x+y*y;
			double l=Math.sqrt(m); 
			System.out.println(l);
		}
	}		
}

