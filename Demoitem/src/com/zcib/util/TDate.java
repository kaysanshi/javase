package com.zcib.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//用于初始化时间的类
public class TDate {
	String string;
	public String getdate(){
	Date now=new Date();
	DateFormat df1=DateFormat.getDateInstance();
		this.string=df1.format(now);
		return string;
	}
	
}
