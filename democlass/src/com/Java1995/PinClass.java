package com.Java1995;

public class PinClass {
//˽���ڲ���
	private int age=12;
	private class In{
		public void print(){
			System.out.println(age);
		}
	}
//	�ⲿ������ڲ����еķ�������ʽ��
	public void outPrint(){
		In p=new In();
		p.print();
	}
}
