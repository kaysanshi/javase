package com.itheima.i18n;

import java.util.Locale;
import java.util.ResourceBundle;
//不同的提示信息
public class ResourceBundleDemo {
	public static void main(String[] args) {
		//加载src下properties文件
		//在读取properties文件时，可以传入一个Locale 实例对象，用于代表一个特定的地理，政治、文化区域
		/*
		 * ResourceBundle在查找的时候首先查指定的然后是系统的，然后是default的默认的
		 */
		ResourceBundle bundle=ResourceBundle.getBundle("resource",Locale.CHINA);
		//读取properties文件中内容
		String value=bundle.getString("username");
		System.out.println(value);
	}
}
