package com.zcib.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zcib.domain.Files;
import com.zcib.service.FileService;

/**
 * Servlet implementation class SaveEditFileServlet
 */
@WebServlet(description = "保存修改的文件", urlPatterns = { "/teacher/SaveEditFileServlet" })
public class SaveEditFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveEditFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String filetitle=request.getParameter("filetitle");
		String desc=request.getParameter("desc");
		String id=request.getParameter("id");
		FileService service=new FileService();
		Files files=new Files();
		files.setDescription(desc);
		files.setFiletitle(filetitle);
		files.setId(Integer.parseInt(id));
		int i=service.updateSaveFile(files);
		if (i!=0) {
			response.getWriter().write("1");
			System.out.println("修改成功");
			request.getRequestDispatcher("/teacher/editFile.jsp").forward(request, response);
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
