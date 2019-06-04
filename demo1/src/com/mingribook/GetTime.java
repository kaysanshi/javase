package com.mingribook;

import java.util.Date;

public class GetTime {
//调用系统内部的时间格式；
	public static void main(String[] args) {
		Date date=new Date();
		System.out.println("默认时间的格式："+date);
		System.out.println("两位24小时制的小时："+String.format("%tH", date));
		System.out.println("两位12小时制的小时："+String.format("%tl", date));
		System.out.println("24制的小时："+String.format("%tk", date));
		System.out.println("12制的小时："+String.format("%tl", date));
		System.out.println("两位小时中的分钟："+String.format("%tM", date));
		System.out.println("两位分钟的中秒："+String.format("%tS", date));
		System.out.println("表示时区缩写形式："+String.format("%tZ", date));
		System.out.println("上午还是下午："+String.format("%tp", date));
		System.out.println("日期时间组合格式化：");
		System.out.println("默认时间的格式："+date);
		System.out.println("24小时制的时间，被格式化为小时和分钟："+String.format("%tR", date));
		System.out.println("24小时制的时间，被格式化为小时和分钟，秒"+String.format("%tT", date));
		System.out.println("12制的时间："+String.format("%tr", date));
		System.out.println("日期被格式化："+String.format("%tD", date));
		System.out.println("ISO 8601格式的完整日期："+String.format("%tF", date));
		System.out.println("日期和时间格式化为："+String.format("%tc", date));
	}

}
