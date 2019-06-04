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
import javax.websocket.Session;

import com.zcib.domain.Student;
import com.zcib.service.StudentService;

/**
 * Servlet implementation class MyHomeServlet
 */
@WebServlet(description = "个人中心", urlPatterns = { "/student/MyHomeServlet" })
public class MyHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyHomeServlet() {
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
		String id=sessio.getAttribute("id").toString();
		if (id==null) {
			response.sendRedirect("/login.jsp");
		}
		System.out.println(id);
		StudentService service=new StudentService();
		Student student=new Student();
		student.setId(Integer.parseInt(id));
		List<Map<String, Object>> list=service.getInfoById(student);
		request.setAttribute("list",list);
		Map<String, Object> map=null;
		for(int i=0;i<list.size();i++){
			map=list.get(i);
		}
		System.out.println(map);
		System.out.println(map.size());
		System.out.println(map.get("realname")+"::"+map.get("email")+map.get("id"));
		if (map.get("addtime")!=null || map.get("age")!=null) {
			request.getRequestDispatcher("/student/myhome.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/student/my.jsp").forward(request, response);
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
