package com.zcib.job;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestprintTime {

	public static void main(String[] args) {
//		��ȡ��ǰʱ�� ���ʱ�׼��
		Date time=new Date();
		System.out.println(time);
//		��ȡ��ǰʱ�� �й�ʽ�ģ�
		Date now=new Date();
		String s="����ʱ�䣺yyy��mm��dd��,E,HH:mm:ss";
		SimpleDateFormat f=new SimpleDateFormat(s);
		System.out.println(f.format(now));
	}

}
