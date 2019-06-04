package com.zcib.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zcib.dao.StudentDao;
import com.zcib.domain.Addmin;
import com.zcib.domain.Student;
import com.zcib.domain.Teacher;
import com.zcib.service.AddminService;
import com.zcib.service.StudentService;
import com.zcib.service.TeacherService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "用户登录", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取登录的用户名和登录的
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String role=request.getParameter("role");
		System.out.println(role);
		System.out.println(password);
		System.out.println(username);
		if (role.equals("student")) {
			StudentService service=new StudentService();
			HttpSession session=request.getSession();
			Student student=service.checkUser(username,password);
			System.out.println(student.getId());
			if(student.getUsername()!=null){
		         //将用户名数据存入session，以便作登录保护用
		         session.setAttribute("username",username); 
		         session.setAttribute("role", role);
		         session.setAttribute("id", String.valueOf(student.getId()));
		         //session.setAttribute("id");
		         //返回登录成功数据（1代表学生）
		         response.getWriter().write("1");
		    }else{
		         //返回登录失败数据（0代表失败）
		    	 response.getWriter().write("0");
		    }
		}else if(role.equals("teacher")) {
			TeacherService service=new TeacherService();
			Teacher teacher=service.cherckUser(username,password);
			System.out.println(teacher.getId());
			HttpSession session=request.getSession();
			if(teacher.getUsername()!=null){
		         //将用户名数据存入session，以便作登录保护用
		         session.setAttribute("username",username);
		         session.setAttribute("id", String.valueOf(teacher.getId()));
		         session.setAttribute("role", role);
		         //返回登录成功数据
		         response.getWriter().write("2");
		    }else{
		         //返回登录失败数据（0代表失败）
		    	 response.getWriter().write("0");
		    }
		}else if(role.equals("admin")){
			AddminService service=new AddminService();
			Addmin addmin=service.cherckuser(username,password);
			HttpSession session=request.getSession();
			if(addmin.getUsername()!=null){
		         //将用户名数据存入session，以便作登录保护用
		         session.setAttribute("username",username);
		         session.setAttribute("role", role);
		         session.setAttribute("id", String.valueOf(addmin.getId()));
		         System.out.println("管理员登录成功");
		         //返回登录成功数据
		         response.getWriter().write("3");
		    }else{
		         //返回登录失败数据（0代表失败）
		    	 response.getWriter().write("0");
		    }
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
