package com.zcib.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zcib.domain.Teacher;
import com.zcib.service.TeacherService;

/**
 * Servlet implementation class AddminDeleteTeacherServlet
 */
@WebServlet(description = "管理员删除教师信息", urlPatterns = { "/addmin/AddminDeleteTeacherServlet" })
public class AddminDeleteTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddminDeleteTeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String teacherid=request.getParameter("teacherid");
		Teacher teacher=new Teacher();
		teacher.setId(Integer.parseInt(teacherid));
		TeacherService service=new TeacherService();
		int i=service.deletTeacher(teacher);
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
