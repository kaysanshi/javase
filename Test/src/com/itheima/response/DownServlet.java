package com.itheima.response;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownServlet
 */
/*
 * servlet中的response下载的功能
 */
@WebServlet("/DownServlet")
public class DownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		///下载的形式应该用这个方式(Y)
		//setHeader头信息不支持中文格式所以命名不能用中文命名这样可以指定下载是所显示的名字
		//response.setHeader("Content-Disposition", "attachment;filename=美女.jpg");
		//方式一:狭隘
		//response.setHeader("Content-Disposition", "attachment;filename=butiful.jpg");
		//解决方式二:url编码可以用ascII码中的转换为url编码然后再转换为指定的编码
		response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode("美女.jpg","utf-8"));
		//这样只是读取到这样的文件但是并没有实现下载功能(N)
		InputStream in=new  FileInputStream(this.getServletContext().getRealPath("1.jpg"));
		OutputStream out=response.getOutputStream();
		byte[]bs=new byte[1024];
		int i=0;
		i=in.read(bs);
		while(i!=-1){
			out.write(bs,0,i);
			i=in.read(bs);
		}
		in.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public static void main(String[] args) throws UnsupportedEncodingException {
		String string="中国";
		//使用特定的编码方案将字符串转换为 application/x-www-form-urlencoded格式。 
		String str2=URLEncoder.encode(string,"utf-8");
		System.out.println(str2);
		//使用特定的编码方案解码 application/x-www-form-urlencoded字符串。
		//将url编码解码成utf-8的形式
		String str3=URLDecoder.decode("%E4%B8%AD%E5%9B%BD","utf-8");
		System.out.println(str3);
	}
}
