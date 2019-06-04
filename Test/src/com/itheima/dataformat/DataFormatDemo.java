package com.itheima.dataformat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import sun.print.resources.serviceui;

public class DataFormatDemo {
	/**
	 * �����ڶ���ת�� Ϊ��ͬ���ַ�����ʽ����ʱ���ݵ������Ի�����ͬ��ת�ɲ�ͬ����
	 */
	public void test1(){
		Date date=new Date();
		DateFormat format=DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL,Locale.CHINA);
		String dateStr=format.format(date);
		System.out.println(dateStr);
		
	}
	/**
	 * @throws ParseException 
	 * 
	 */
	public void test2() throws ParseException{
		String daString="2010��1��25�� ������ ����13ʱ15��20�� CST";
		DateFormat format=DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.CHINA);
		Date date=format.parse(daString);
		System.out.println(date.toLocaleString());
	}
	/**
	 * 9��~~10��##2013��**12ʱ%20��%10��
	 * @throws ParseException 
	 */
	
	public void test3() throws ParseException{
		String dateStr = "09��~~10��##2013��**12ʱ%20��%10��";
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM��~~dd��##yyyy��**HHʱ%mm��%ss��");
		Date date = dateFormat.parse(dateStr);
		System.out.println(date.toLocaleString());
	}
	
	
	public void test4(){
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM��~~dd��##yyyy��**HHʱ%mm��%ss��");
		String str = dateFormat.format(date);
		System.out.println(str);
	}
	
}
