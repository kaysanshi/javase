package com.itheima.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxServletone
 */
@WebServlet("/AjaxServletone")
public class AjaxServletone extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxServletone() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			//获取参数
		//post提交
		request.setCharacterEncoding("UTF-8");
		String  name=request.getParameter("name");
		String  age=request.getParameter("age");
		System.out.println(name+","+age);
		//java代码只能返回一个json格式的字符串
		//也要创建个json格式的字符串但是需要转义
		//get提交
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("{\"name\":\"汤姆\",\"age\":21}");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
