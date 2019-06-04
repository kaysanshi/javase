package com.zcib.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zcib.domain.Student;
import com.zcib.service.StudentService;
import com.zcib.service.TeacherService;

/**
 * Servlet implementation class TeacherMyHomeServlet
 */
@WebServlet(description = "教师个人管理", urlPatterns = { "/teacher/TeacherMyHomeServlet" })
public class TeacherMyHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherMyHomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//
		HttpSession sessio=request.getSession();
		String teacherid=sessio.getAttribute("id").toString();
		if (teacherid==null) {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
		System.out.println(teacherid);
		TeacherService service=new TeacherService();
		List<Map<String, Object>> list=service.getTeacherId(teacherid);
		
		request.setAttribute("list",list);
		Map<String, Object> map=null;
		for(int i=0;i<list.size();i++){
			map=list.get(i);
		}
		System.out.println(map);
		System.out.println("map:"+map.size());
		if (map.get("eamil")!=null || map.get("age")!=null) {
			request.getRequestDispatcher("/teacher/upmyhome.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/teacher/my.jsp").forward(request, response);
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
