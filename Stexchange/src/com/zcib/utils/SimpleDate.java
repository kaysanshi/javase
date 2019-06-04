package com.zcib.utils;
import java.text.SimpleDateFormat;
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
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		this.string=df.format(now);
		return string;
	}
}
