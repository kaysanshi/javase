package com.Mingribook;

public class Exception1 {
//�쳣2
//	����ʱ�쳣
	int num[]={100,80,60,70,20,52};
	public void setNum(int index,int value){
		num[index]=value;
	}
	public int getNum(int index){
		return num[index];
	}
	public static void main(String[]args){
		Exception1 p=new Exception1();
//		���÷����е���������ֵΪ0 ��Ԫ��ֵ
		int value=p.getNum(0);
		System.out.println(value);
//		���÷����е���������ֵΪ6��Ԫ��ֵ��������õ��±�
//		java.lang.ArrayIndexOutOfBoundsException:
		value=p.getNum(6);
		System.out.println(value);
//		�������һ��Ԫ��
		value=p.getNum(5);
		System.out.println(value);
	}
}
