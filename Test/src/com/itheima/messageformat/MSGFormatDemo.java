package com.itheima.messageformat;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MSGFormatDemo {
	//At 12:30 pm on jul 3,1998, a hurricance destroyed 99 houses and caused $1000000 of damage
	//��һ��������ж���͹��ʻ���ص�����ʱ,��Ҫ���и��ַ������͹��ʻ���ص����ݹ��ʻ�����ƴ���ַ���.
	public static void main(String[] args) {
		String str = "At {0,time,full} on {1,date,full}, a hurricance destroyed {2,number} houses and caused {3,number,currency} of damage";
		MessageFormat format = new MessageFormat(str,Locale.CHINA);
		
		Calendar c = Calendar.getInstance();
		c.set(1998, 6, 3, 12, 30, 0);
		Date date = c.getTime();
		
		str = format.format(new Object[]{date,date,99,1000000});
		System.out.println(str);
	}
}
