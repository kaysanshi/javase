package com.zcib.book.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestDate {
	public static void main(String[] args) {
		Date p=new Date();
		p.getTime();//
		System.out.println(p.getTime());
//date Format��
//		��ʽ
//		 ����
		DateFormat df1=DateFormat.getDateInstance();
		String string=df1.format(new Date());
		System.out.println(string);
//		���ں�ʱ��һ����ʾ��ȷ����
		DateFormat df2=DateFormat.getDateTimeInstance();
		System.out.println(df2.format(new Date()));
//		��ʽ
//		������
		DateFormat df3=DateFormat.getDateInstance(DateFormat.YEAR_FIELD,new Locale("zh","CN"));
		System.out.println(df3.format(new Date()));
//		��������������
		DateFormat df4=DateFormat.getDateTimeInstance(DateFormat.YEAR_FIELD,DateFormat.ERA_FIELD,new Locale("zh","CN"));
		System.out.println(df4.format(new Date()));
//		simpleDateFormate��
		Date now=new Date();
		String s="����ʱ�䣺yyy��MM��dd��,E,HH:mm:ss";
		SimpleDateFormat f=new SimpleDateFormat(s);
		System.out.println(f.format(now));
	}
	
}

