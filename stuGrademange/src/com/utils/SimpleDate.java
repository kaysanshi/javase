package com.utils;

import java.text.DateFormat;
import java.util.Date;
//���ʱ����ࣻ
public class SimpleDate {
	
	String string;
	public String getdate(){
	Date now=new Date();
	DateFormat df1=DateFormat.getDateInstance();
		this.string=df1.format(now);
		return string;
	}
}
