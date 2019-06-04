package com.zcib.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zcib.domain.Addmin;
import com.zcib.domain.Student;
import com.zcib.domain.Teacher;
import com.zcib.service.AddminService;
import com.zcib.service.StudentService;
import com.zcib.service.TeacherService;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet(description = "用户注册", urlPatterns = {"/RegistServlet" })
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取注册的用户的信息
		//判断哪一个用户登录注册
		String username=request.getParameter("user");
		String password=request.getParameter("password");
		String role=request.getParameter("role");
		System.out.println("11"+role);
		String verfyCode=(String) request.getSession().getAttribute("valistrt");
		String verfycode=request.getParameter("verfycode");
		PrintWriter out = response.getWriter();
		if(verfycode == null || verfyCode == null || !verfycode.equals(verfyCode)){
			
			request.setAttribute("msg", "<font color='red'>输入有误</font>");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		if (role.equals("student")) {
			StudentService service=new StudentService();
			Student student=new Student();
			student.setUsername(username);
			student.setPassword(password);
			System.out.println(verfyCode);
			System.out.println(verfycode);
			System.out.println(student.getUsername());
			System.out.println(student.getPassword());
			boolean status=service.registStudent(student);
			if (status==true) {
				out.println("1");
			}else{
				out.println("0");
			}
			out.flush();
			out.close();
		}else if(role.equals("teacher")){
			TeacherService service=new TeacherService();
			Teacher teacher=new Teacher();
			teacher.setUsername(username);
			teacher.setPassword(password);
			boolean status=service.registTeacher(teacher);
			if (status==true) {
				out.println("1");
			}else{
				out.println("0");
			}
			out.flush();
			out.close();
		}else if(role.equals("admin")){
			AddminService service=new AddminService();
			Addmin addmin=new Addmin();
			addmin.setUsername(username);
			addmin.setPassword(password);
			boolean status=service.registAddmin(addmin);
			if (status==true) {
				out.println("1");
			}else{
				out.println("0");
			}
			out.flush();
			out.close();
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
