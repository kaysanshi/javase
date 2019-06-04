package com.zcib.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zcib.service.FileService;

/**
 * Servlet implementation class DeletefilesServlet
 */
@WebServlet(description = "删除文件", urlPatterns = { "/teacher/DeletefilesServlet" })
public class DeletefilesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletefilesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//文件删除
		String filesid=request.getParameter("filesid");
		FileService service=new FileService();
		boolean status= service.deletefile(filesid);
		if (status==true) {
			response.getWriter().write("1");;
			System.out.println("删除成功");
		}else{
			response.getWriter().write("0");
			System.out.println("删除失败");
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
