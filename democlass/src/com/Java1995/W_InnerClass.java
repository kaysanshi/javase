package com.Java1995;

public class W_InnerClass {
//�����ڲ���
	private int age =13;
	public void Print(  int x){
		class In{
			public void inPrint(){
				System.out.println(x);
				System.out.println(age);
			}
		}
//		�ⲿ���еķ��������ڲ������
		In in=new In();
		in.inPrint();
	}
}
