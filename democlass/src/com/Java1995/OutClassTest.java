package com.Java1995;

public class OutClassTest {
	public static void main(String[] args) {
		OutClass out=new OutClass();
		out.getInner();
		System.out.println(out.i);//�Աȵ����ڲ���ĵ��ã�
//		��ͼ�ڲ������д����ڲ������ᱨ��
//		Inner p1=new Inner();
//		�������ȷʵҪʹ���ڲ���ʱ��ʱ��Ҫ�����·�����
		OutClass.Inner p1=out.new Inner(); 
		p1.put();
	}
	
}
