package com.java1995;

public class TestReturnAndBreak {
	//���Լ���ѭ����ֹ��䣻
	public static void main(String[] args) {
		for(int i=0;i<=9;i++){
			if(i==5){
				//break;//��ֹ����ѭ��������ִ��������䣻
				return;//��ֹ����ѭ�����������壻����ִ��������䣻
				//continue;//ѭ��ִ��֮�󣻼���ִ��������䣻
			}
			System.out.println(i);
		}
		System.out.println("hello");
	}

}
