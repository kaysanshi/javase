package com.xiaoxiao.filter;

//import java.io.UnsupportedEncodingException;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequestWrapper;
//
//public class EncodingRequest extends HttpServletRequestWrapper{
//	private HttpServletRequest req;
//
//	public EncodingRequest(HttpServletRequest request) {
//		super(request);
//		this.req=request;
//	}
//
//	/*
//	 * 用来重写getParameter方法，对get请求重新编码
//	 */
//	@Override
//	public String getParameter(String name) {
//		String value=req.getParameter(name);
//		System.out.println("转换前："+value);
//		try {
//			if(value!=null)
//				value=new String(value.getBytes("iso-8859-1"),"utf-8");
//			System.out.println("转换后："+value);
//		} catch (UnsupportedEncodingException e) {
//			throw new RuntimeException(e);
//		}
//		return 	value;
//	}
//}


import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 装饰reqeust
 * @author 555
 *
 */
public class EncodingRequest extends HttpServletRequestWrapper {
	private HttpServletRequest req;
	
	public EncodingRequest(HttpServletRequest request) {
		super(request);
		this.req = request;
	}

	public String getParameter(String name) {
		String value = req.getParameter(name);
		// 处理编码问题
		try {
			if(value!=null)
				value = new String(value.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		
		return value;
	}
}
