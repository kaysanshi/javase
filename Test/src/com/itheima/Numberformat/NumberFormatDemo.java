package com.itheima.Numberformat;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;


public class NumberFormatDemo {
	/**
	 * 将数字表示成字符串形式,可以根据不同的地区语言环境转换为不同的字符串
	 */

	public void test1(){
		double money = 1000000.00;
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
		String moneyStr = format.format(money);
		System.out.println(moneyStr);
	}
	/**
	 * $1,000,000.00
	 * @throws ParseException 
	 */

	public void test2() throws ParseException{
		String moneyStr = "$1,000,000.00";
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
		double money = format.parse(moneyStr).doubleValue();
		System.out.println(money);
	}
}
