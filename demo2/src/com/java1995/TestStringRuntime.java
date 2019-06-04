package com.java1995;

import java.util.Date;

public class TestStringRuntime {
	public static void main(String []args){
		Date d=new Date();
		System.out.println(d);
		String str ="";
//		���������
		long starTime=System.currentTimeMillis();
		for(long i=0;i<100000;i++){
			str=str+i;
		}
		long endTime=System.currentTimeMillis();
		long time=endTime-starTime;
		System.out.println("String���ĵ�ʱ�䣺"+time);
		System.out.println(d);
//		����StringBuilder()�ķ����Ǽ����ַ��䲢��ӡ���
		StringBuilder builder=new StringBuilder("");
		starTime=System.currentTimeMillis();
		for(long j=0;j<100000;j++){
		builder.append(j);
		}
		endTime=System.currentTimeMillis();
		time=endTime-starTime;
		System.out.println("String���ĵ�ʱ�䣺"+time);
 
//		StringtoString����
//		�ȹ����ַ�����������
		StringBuilder builder1=new StringBuilder("HelloWord");
		String s=builder1.toString();//���ַ���������ת��Ϊ�ַ���
		System.out.println("s="+s);
		System.out.println("builder1="+builder1);
		
	}

}
