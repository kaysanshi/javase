package com.zcib.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//���ڳ�ʼ��ʱ�����
public class TDate {
	String string;
	public String getdate(){
	Date now=new Date();
	DateFormat df1=DateFormat.getDateInstance();
		this.string=df1.format(now);
		return string;
	}
	
}
