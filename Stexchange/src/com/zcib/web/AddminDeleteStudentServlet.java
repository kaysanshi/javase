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
 * Servlet implementation class AddminDeleteStudentServlet
 */
@WebServlet(description = "管理员删除学生", urlPatterns = { "/addmin/AddminDeleteStudentServlet" })
public class AddminDeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddminDeleteStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			String stuid=request.getParameter("stuid");
			Student student=new Student();
			student.setId(Integer.parseInt(stuid));
			StudentService service=new StudentService();
			int i=service.deletStudent(student);
			if (i!=0) {
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
