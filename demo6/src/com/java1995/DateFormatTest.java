package com.java1995;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatTest {
//Date �����DateFormat,����һ����
	public static void main(String[] args) {
		Date date=new Date();
//		getInstance() ��ȡ�����ں�ʱ����ʹ��SHORT��ʽ��Ĭ������/ʱ���ʽ������ 
		DateFormat df1=DateFormat.getInstance();
		System.out.println("������ľ�̬������õ�ʵ����"+df1.format(date));
//		�����Ƕ����ĸ�ʽ�Ŀ���SimpleDateFormat��һ������
		DateFormat df2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		DateFormat df3=new SimpleDateFormat("yyyy��MM��dd��hhʱmm��ss��");
		DateFormat df4=new SimpleDateFormat("yyy��MM��dd��");
		DateFormat df5=new SimpleDateFormat("yy�꣬MM��");
		DateFormat df6=new SimpleDateFormat("yyy��MMM");
		DateFormat df7=new SimpleDateFormat("hh:mm:ss");
		System.out.println(df2.format(date));
		System.out.println(df3.format(date));
		System.out.println("yyy��MM��dd�գ���"+df4.format(date));
		System.out.println("yy�꣬MM�£���"+df5.format(date));
		System.out.println("yyy��MMM����"+df6.format(date));
		System.out.println(df7.format(date));
	}

}
