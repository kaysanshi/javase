package com.zcib.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zcib.domain.Student;
import com.zcib.service.StudentService;

/**
 * Servlet implementation class SaveStudentInfoServlet
 */
@WebServlet(description = "信息完善", urlPatterns = { "/student/SaveStudentInfoServlet" })
public class SaveStudentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveStudentInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//信息完善
		String id =request.getParameter("id");
		String realname=request.getParameter("realname");
		String sex=request.getParameter("sex");
		String age=request.getParameter("age");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		System.out.println(id+","+realname+","+sex+","+age+","+email+","+address);
		Student student=new Student();
		student.setId(Integer.parseInt(id));
		student.setAddress(address);
		student.setAge(Integer.parseInt(age));
		student.setRealname(realname);
		student.setEmail(email);
		student.setSex(sex);
		StudentService service=new StudentService();
		boolean status=service.saveInfo(student);
		if (status==true) {
			response.getWriter().write("1");
		}else{
			response.getWriter().write("0");
		}
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
