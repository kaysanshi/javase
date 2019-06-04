package com.zcib.web;

import java.awt.image.BandCombineOp;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zcib.domain.Files;
import com.zcib.service.FileService;
import com.zcib.utils.PageBean;

/**
 * Servlet implementation class ListFilesServlet
 */
@WebServlet(description = "文件列表", urlPatterns = { "/teacher/ListFilesServlet"})
public class ListFilesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListFilesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		HttpSession session=request.getSession();
		String teacherid=(String)session.getAttribute("id");
		//String filename=request.getParameter("realname");
		FileService service=new FileService();
		List<Map<String,Object>>list=service.getListFile();
		System.out.println(list.toString());
		//PageBean pageBean=new PageBean();
		//获的行数
//		//int totalRows=service.getTotarow();
//		System.out.println(totalRows);
//		pageBean.setTotalRows(totalRows);
		if(list.size()<0){
			response.getWriter().write("0");
			System.out.println("列表为null");
		}else{
			String page = request.getParameter("page");
			// 当前的页数
			int curPage = 0; 
			//没有获得page值的处理
			if (page == null || page.length() < 1) { 
				curPage = 1;
			} else {
				curPage = Integer.parseInt(page);
			}
			 
			///
			System.out.println(curPage);
			/**
			 * 通过人物获取
			 */
           PageBean pageBean=service.getPageBean(curPage,teacherid);
          
			System.out.println("1");
			//request.setAttribute("list", list);
			
			request.setAttribute("pageBean", pageBean);
			if(path.equals("/teacher")){
				request.getRequestDispatcher("/teacher/listfile.jsp").forward(request, response);
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
