package com.zcibJOB;   
import java.util.Random;

public class Point {
//	���������������10��(x,y)ֵ���ɴ˴�����Point��ʵ������һ��������
//	����ԭ�㣨0��0���ľ�����С�����˳��������еĵ㼰��ԭ��ľ��롣
	//����������ķ�����
	static int x=new Random().nextInt(30);
	static int y=new Random().nextInt(30);
	public static void main(String[]args){
		int arr[]=new int[10];
		System.out.println("x���������Ϊ��");
		for(int i=0;i<arr.length;i++){
			int x=new Random().nextInt(30);
			System.out.println(x);
		}
		System.out.println("y���������Ϊ��");
		for(int i=0;i<arr.length;i++){
			int y=new Random().nextInt(30);
			System.out.println(y);
		}
		System.out.println("(x ,y) ��������:");
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

