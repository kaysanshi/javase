package com.MindView.net;

import java.util.Scanner;

/*
 * ���⣺쳲��������У�����1.1��2,3,5,8,13,21,34����ɴӵ���������ǰ����Ԫ�صĺ�
 * ����һ����������һ��ֵ����ʾ���ֵ֮ǰ��쳲��������У�
 */
public class Fibonacci {
	public void getFibonacci(int m){
		int a[]=new int[40];
		 	a[0]=1;
		 	a[1]=1;
		for(int i=0;i<a.length;i++){
//			���ж�ǰ��i<2����µ����֣��ٰ�i����ֵΪi�����ֵ��
			if(i<2){
				System.out.print(a[0]+" "+a[1]+" ");
				i=2;
			}
			a[i]=a[i-2]+a[i-1];
//			System.out.print(a[i]+" ");
			if(a[i]<=m){
//	���бȽ������
			System.out.print(a[i]+" ");
			}
		}
	}

	public static void main(String[] args) {
		Fibonacci fn=new Fibonacci();
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		fn.getFibonacci(n);
		scan.close();

	}

}
