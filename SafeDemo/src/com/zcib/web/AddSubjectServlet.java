package com.zcib.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import org.apache.commons.beanutils.BeanUtils;

import com.zcib.domain.Problem;
import com.zcib.factory.BasicFactory;
import com.zcib.service.ProblemService;


/**
 * Servlet implementation class AddSubjectServlet
 */
@WebServlet(description = "问题添加", urlPatterns = { "/AddSubjectServlet","/addmin/AddSubjectServlet" })
public class AddSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSubjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProblemService service=BasicFactory.getFactory().GetInstance(ProblemService.class);
		Problem problem=new Problem();
		//获得项目名
		String requestPath1=request.getContextPath();
		int star=requestPath1.length();
		System.out.println(star);
		//获取请求的路径
		String requestpath=request.getRequestURI();
		System.out.println(requestpath);
		int i=requestpath.lastIndexOf("/");
		System.out.println(i);
		//获取请求的是哪一个
		String path=requestpath.substring(star,i);
		System.out.println(path);
		int  id=(int)request.getSession().getAttribute("id");
		if (path.equals("/addmin")) {
			try {
				//实例对象
				problem.setUpid(id);
				BeanUtils.populate(problem,  request.getParameterMap());
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Boolean status=service.addProblem(problem);
			//3.
			if (status==true) {
				response.getWriter().write("1");
			}else{
				response.getWriter().write("0");
			}

			
		}
		
		request.setAttribute("problem", problem);
		request.getRequestDispatcher("/ListProblemServlet").forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
