package com.MindView.net;

import java.util.Random;

public class TestRandom {
//дһ���������25��intֵ��if else����  package 66 of  <<Thinking in Java>>
	public static void main(String[] args) {
		Random rand =new Random();
		int a[]=new int[25];
		for(int i=0;i<25;i++){
			a[i]=rand.nextInt(100);//�ڴ˿������ĸ������в����������
		}
		System.out.println("�����һ�η��ࣺ");
		for(int x:a){
			if(x>=50){
				System.out.println(x);
			}
		}
		System.out.println("����ڶ��η��ࣺ");
		for(int x:a){
		 if(x<50 && x>30){
			System.out.println(x);
		 	}
		}
		System.out.println("��������η��ࣺ");
		for(int x:a){
			if(x>=0&&x<=30){
				System.out.println(x);
			}
		}
	}

}
