package com.java1995;

public class TestArrayOfTwo4 {
	//��foreach���;�÷���for(Ԫ�ر���:�������� obj){
//						������x��Java���;}������������һά�Ͷ�ά����;
//�ڶ�ά������Ӧ��ʱҪ������Ԫ�ر���(int ��������1[]:������)����������Ϊ��������;
//Ȼ���ڲ�����һ�����õ�Ԫ�ر�����Ϊ��������(int �µ�������2:��������1);
	public static void main(String[] args) {
		int arr1[][]={{3,5,4},{2,6,7}};
		System.out.println("��ά�����Ԫ��:");
		for(int x[]:arr1){
			for(int e:x){
				System.out.print(e+" ");
			}
			System.out.println();
		}
	}
}
