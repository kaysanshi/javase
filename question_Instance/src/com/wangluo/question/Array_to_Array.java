package com.wangluo.question;

import java.util.Scanner;

public class Array_to_Array {
//	���鷴ת ��
//	һ��Ҫ�ҳ����Ժ����е�ԭ��
	public static void change(int[] arr){
		for(int i=0;i<arr.length;i++){
			if(arr[i]!=arr[arr.length-i-1]){
				int temp ;
				temp=arr[i];
				arr[i]=arr[arr.length-i-1];
				arr[arr.length-i-1]=temp;
			}	
		}
			System.out.println();
			System.out.println("��ת�������");
			for(int x: arr)
			System.out.print(x+" ");
	}
//	����forѭ�����������飬��ʼ���ʽ��������ָ�룬��¼��һԬ���������һ��Ԫ�أ�int min=0,max=
//	����boolean���ʽ��
	public static void Change(int[] arr){
		for(int min=0,max=arr.length-1;min<=max;min++,max--){
			int temp=arr[min];
			arr[min]=arr[max];
			arr[max]=temp;
		}
		System.out.println();
		System.out.println("��ת�������");
		for(int x:arr){
			System.out.print(x+" ");
		}
	}
//	����Ԫ�صķ�ת��
	public static void main(String[] args) {
		int arr[] =new int[6];
		Scanner scan=new Scanner(System.in);
		for(int i=0;i<arr.length;i++){
			arr[i]=scan.nextInt();
		}
		for(int x: arr){
			System.out.print(x+" ");
		}
		scan.close();
		Array_to_Array.Change(arr);
		Array_to_Array.change(arr);
	}
}
