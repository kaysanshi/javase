package com.itheima.Numberformat;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;


public class NumberFormatDemo {
	/**
	 * �����ֱ�ʾ���ַ�����ʽ,���Ը��ݲ�ͬ�ĵ������Ի���ת��Ϊ��ͬ���ַ���
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
