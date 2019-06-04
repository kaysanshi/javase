package com.itheima.response;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OutServlet
 */
/**
 * 
 * 向浏览器中输出信息
 *
 */
@WebServlet("/OutServlet")
public class OutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//这里是一个编码过程,用的是操作系统的编码GBK;
		//浏览器打开时也是GBK的打开方式所以没有乱码
		//response.getOutputStream().write("English very so easy".getBytes());
		//这是会出现乱码,需要让浏览器也使用Utf-8编码打开才不会乱码或则用下面的方法
		//response.setHeader("Content-Type", "text/html;charset=utf-8");
		//response.getOutputStream().write("中国".getBytes("utf-8"));
		/*这时用中文又会乱码这时是只能是服务器把汉字转换为010101然后去查iso8859-1码表
		这个码表中没有中文,如果在iso8859-1找不到的话会被转换为?,然而浏览器又会用GBK打开这个编码所以会显示??
		这时要指定服务器查的码表
		*/
		//指定服务器查的码表
		response.setCharacterEncoding("gbk");
		response.getWriter().write("beijiang");
		response.getWriter().write("中国");
		//或者这样;
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write("中国");
		//或者这样;setContentType可以直接指定浏览器和服务器的编码方式
		response.setContentType("text/html,charset=utf-8");
		response.getWriter().write("中国");
		//或者这样SetCharacterEnconding指定服务器的编码
		//setContentType指定浏览器的编码
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html,charset=utf-8");
		response.getWriter().write("中国");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
