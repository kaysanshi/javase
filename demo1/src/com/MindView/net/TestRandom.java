package com.MindView.net;

import java.util.Random;

public class TestRandom {
//写一个程序产生25个int值用if else分类  package 66 of  <<Thinking in Java>>
	public static void main(String[] args) {
		Random rand =new Random();
		int a[]=new int[25];
		for(int i=0;i<25;i++){
			a[i]=rand.nextInt(100);//在此控制在哪个区域中产生随机数；
		}
		System.out.println("将其第一次分类：");
		for(int x:a){
			if(x>=50){
				System.out.println(x);
			}
		}
		System.out.println("将其第二次分类：");
		for(int x:a){
		 if(x<50 && x>30){
			System.out.println(x);
		 	}
		}
		System.out.println("将其第三次分类：");
		for(int x:a){
			if(x>=0&&x<=30){
				System.out.println(x);
			}
		}
	}

}
