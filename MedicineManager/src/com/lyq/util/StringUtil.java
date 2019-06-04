package com.lyq.util;

import java.net.URLEncoder;
/**
 * 字符串工具类,用于对项目中的字符串进行处理
 * @author Li Yong Qiang
 */
public class StringUtil {
	/**
	 * 把字符串数组转换成字符串
	 * @param arr String数组
	 * @return String
	 */
	public static String arr2Str(String[] arr){
		String temp = "" ;		// 字符串变量
		if(arr != null && arr.length > 0){
			// 循环获取数组中的值
			for(int i = 0 ; i < arr.length ; i ++){
				// 判断数组下标是否到达末尾
				if(i != (arr.length - 1)){
					// 组成新的字符串并以,号结尾
					temp = temp + arr[i] + "," ;
				}
				else{
					// 组成新的字符串
					temp = temp + arr[i] ;
				}
			}
		}
		return temp ;
	}
	/**
	 * 对字符串进行URL编码
	 * @param s 字符串
	 * @return String
	 */
	public static String encodeURL(String s){
		try {
			//对链接进行URL编码
			s = URLEncoder.encode(s,"GBK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	/**
	 * 对字符串进行gbk编码
	 * @param s 字符串
	 * @return 编码后的字符串
	 */
	public static String encodeZh(String s){
		try {
			// 对字符串进行gbk编码
			s = new String(s.getBytes("iso-8859-1"),"gbk");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
}
