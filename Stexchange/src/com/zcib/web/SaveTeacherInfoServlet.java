package com.zcib.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zcib.domain.Student;
import com.zcib.domain.Teacher;
import com.zcib.service.StudentService;
import com.zcib.service.TeacherService;
import com.zcib.utils.SimpleDate;

/**
 * Servlet implementation class SaveTeacherInfoServlet
 */
@WebServlet(description = "教师信息完善和修改", urlPatterns = { "/teacher/SaveTeacherInfoServlet" })
public class SaveTeacherInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveTeacherInfoServlet() {
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
				Teacher teacher =new Teacher();
				teacher.setId(Integer.parseInt(id));
				teacher.setAge(Integer.parseInt(age));
				teacher.setRealname(realname);
				teacher.setEmail(email);
				teacher.setSex(sex);
				teacher.setAddtime(new SimpleDate().getdate());
				TeacherService service=new TeacherService();
				boolean status=service.saveInfo(teacher);
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
