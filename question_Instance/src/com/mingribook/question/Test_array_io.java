package com.mingribook.question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test_array_io {
	public static void main(String[] args) {
	int arr[]=new int[10];
	System.out.println("��������������е�ֵ��");
	Scanner scan =new Scanner(System.in);
	for(int i=0;i<arr.length;i++){
		 arr[i]=scan.nextInt();
		}
	for(int i=0;i<arr.length;i++){
		System.out.print(arr[i]+" ");
	}
	
	System.out.println("���ڲ�����һ�ַ�������:");
	System.out.println("�ڴ����������ֵҪ�ûس�����");
	int[]arr1=new int[10];
	for(int i=0;i<arr1.length;i++){
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
			arr1[i]=Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
	for(int i=0;i<arr1.length;i++){
		System.out.print(arr1[i]+" ");
		}
	scan.close();
	}

}
