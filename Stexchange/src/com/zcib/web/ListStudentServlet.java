package com.zcib.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zcib.service.StudentService;
import com.zcib.utils.PageBean;

/**
 * Servlet implementation class ListStudentServlet
 */
@WebServlet(description = "学生列表", urlPatterns = { "/addmin/ListStudentServlet" })
public class ListStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentService service=new StudentService();
		List<Map<String,Object>> list =service.getAllStudent();
		String page = request.getParameter("page");
		// 当前的页数
		int curPage = 0; 
		//没有获得page值的处理
		if (page == null || page.length() < 1) { 
			curPage = 1;
		} else {
			curPage = Integer.parseInt(page);
		}
		 
		///
		System.out.println(curPage);
		/**
		 * 通过人物获取
		 */
       PageBean pageBean=service.getAllStudentPageBean(curPage);
       request.setAttribute("pageBean", pageBean);
       request.getRequestDispatcher("/addmin/liststudent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
