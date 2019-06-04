package com.zcibJOB;
import java.util.Scanner;
public class Eg5 {
//java实现数组的自定义输入；利用输入流和for循环实现；
	public static void main(String[] args) {
		int a[]=new int[5];
		Scanner scan=new Scanner(System.in);
		for(int i=0;i<a.length;i++){
			 a[i]= scan.nextInt();
		}
		scan.close();
//		实现自定义输入后输出；
//		for(int i=0;i<a.length;i++){
//			System.out.print(a[i]+" ");
//		}
		int MAX=a[0];
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length-1;j++){
				if(MAX<a[j+1]){
					MAX=a[j+1];
				}
			}
			//System.out.println(MAX);	
		}
//		System.out.println();
		System.out.println(MAX);
	}
}
