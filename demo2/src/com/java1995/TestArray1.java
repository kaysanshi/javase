package com.java1995;

import java.util.Arrays;

public class TestArray1 {
//����滻�����Ԫ��;1.fill(int[]a,int value)����;���ڿհ���������,����������͵������ÿһ��Ԫ��;
//2.fill(int[]a,int fromindex,toindex,int value)����;���������ָ���滻��Χ���滻,��ǰ������;
	public static void main(String[] args) {
		int arr[]=new int[5];
		Arrays.fill(arr,5);//�հ���������
		for(int i=0;i<arr.length;i++){
			System.out.println("��"+(i+1)+"��Ԫ����:"+arr[i]);
		}
		System.out.println("�ڶ����滻����:");
		int array[]=new int[]{45,12,2,10,1};
		Arrays.fill(array,1,3,6);//����ʽ�滻������ǰ
		for( int j=0;j<array.length;j++){
			System.out.println("��"+j+"��Ԫ����:"+array[j]);
		}
	}
}
