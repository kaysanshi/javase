package com.itheima.response;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NoCatchServlet
 */
/*
 * 实现浏览器是否缓存资源1.不进行缓冲
 */
@WebServlet("/NoCatchServlet")
public class NoCatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoCatchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置响应头信息在浏览器中不进行缓存
		response.setIntHeader("Expires", -1);
		response.setHeader("Cache-control","no-cache");
		response.setHeader("Pragma","no-cache");
		//同时设置服务器和浏览器的编码方式
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("当前时间是:"+new Date().toLocaleString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
