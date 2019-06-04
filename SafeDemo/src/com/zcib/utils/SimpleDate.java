package com.zcib.utils;

import java.text.DateFormat;
import java.util.Date;
/**
 * 获取时间
 * @author 555
 *
 */
public class SimpleDate {
	
	String string;
	public String getdate(){
	Date now=new Date();
	DateFormat df1=DateFormat.getDateInstance();
		this.string=df1.format(now);
		return string;
	}
}
