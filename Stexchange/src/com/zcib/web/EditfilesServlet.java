package com.zcib.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sun.org.apache.bcel.internal.classfile.Field;
import com.zcib.service.FileService;

/**
 * Servlet implementation class EditfilesServlet
 */
@WebServlet(description = "教师编辑文件信息", urlPatterns = { "/teacher/EditfilesServlet" })
public class EditfilesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditfilesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("filesid");
		String teeacherid=(String)request.getSession().getAttribute("id");
		FileService service=new FileService();
		List<Map<String, Object>> list=service.getFileById(id);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/teacher/editFile.jsp").forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
