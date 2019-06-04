package com.Mingribook;

public class Exception1 {
//异常2
//	运行时异常
	int num[]={100,80,60,70,20,52};
	public void setNum(int index,int value){
		num[index]=value;
	}
	public int getNum(int index){
		return num[index];
	}
	public static void main(String[]args){
		Exception1 p=new Exception1();
//		调用方法中的数组索引值为0 的元素值
		int value=p.getNum(0);
		System.out.println(value);
//		调用方法中的数组索引值为6的元素值超出数组得的下标
//		java.lang.ArrayIndexOutOfBoundsException:
		value=p.getNum(6);
		System.out.println(value);
//		调用最后一个元素
		value=p.getNum(5);
		System.out.println(value);
	}
}
