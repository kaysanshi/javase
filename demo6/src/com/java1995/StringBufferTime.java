package com.java1995;

import java.util.Date;

public class StringBufferTime {
//	���Զ���ļ�������ʱ��
	public static void main(String[] args) {
		System.out.println(new Date());
		String s="";
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<10000;i++){
			sb.append(i);
		}
		System.out.println(new Date());
//		String ��Ĳ��ԣ�
		
		System.out.println("����String���ص�ʱ��");
		for(int i=0;i<10000;i++){
			s+=i;
		}
		System.out.println(new Date());
	}

}
