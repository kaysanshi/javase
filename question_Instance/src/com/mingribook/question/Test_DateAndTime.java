package com.mingribook.question;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test_DateAndTime {
/*
 * ʱ�����Ϣ��ʽ�����ٽ����������ո�ʽ�����
 */
	public static void main(String[] args) {
		Date time=new Date();
		System.out.println(time);
		String s="yyy��mm��dd��";
		SimpleDateFormat m=new SimpleDateFormat(s);
		System.out.println(m.format(time));

	}

}
