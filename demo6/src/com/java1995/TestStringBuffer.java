package com.java1995;

public class TestStringBuffer {

	public static void main(String[] args) {
//		StringBuffer ���ֹ��췽��
		StringBuffer sb=new StringBuffer();
//		capacity()���ص�ǰ��������С
		System.out.println(sb.capacity());
		StringBuffer sb1=new StringBuffer("abc");
		System.out.println(sb1.capacity());
//		���ǽ��д�ֵ�� int�������ַ�����ʾ���ӵ������С�
		StringBuffer sb2=new StringBuffer(1000);
		System.out.println(sb2.capacity());
//		��������������д����ַ�����ƴ��
		StringBuffer sb3=new StringBuffer("hello");
		sb3.append("every body"+"\n");
		sb3.append("you must ");
		sb3.append("come on!!!");
//		��������StringBuffer()�����ٴμ��뵽������
		sb3.append(sb1);
//		����ķ����ǣ�
		System.out.println(sb3.toString());
		
	}

}
