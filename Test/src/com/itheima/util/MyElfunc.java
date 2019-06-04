package com.itheima.util;

import java.net.URLEncoder;


public class MyElfunc {
	public static String myEncode(String str,String encode){
		try {
			return URLEncoder.encode(str,encode);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		
	}
}
