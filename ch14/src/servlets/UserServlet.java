package servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.UserService;
import util.PageBean;

@WebServlet("/us/*")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
	public UserServlet() {
        super();
    }
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("GBK");
		//分析文件路径，根据路径进行不同的处理。
		String requestPath=request.getRequestURI();
		int i=requestPath.lastIndexOf('/');
		String path=requestPath.substring(i);
		RequestDispatcher rd=null;
		//创建模型层对象
		UserService us=new UserService();
		if(path.equals("/listAll")){
			//所有文件显示功能，带分页处理。
			// 获得要显示的页数
			String page = request.getParameter("page");
			// 当前的页数
			int curPage = 0; 
			//没有获得page值的处理
			if (page == null || page.length() < 1) { 
				curPage = 1;
			} else {
				curPage = Integer.parseInt(page);
			}
            PageBean pageBean=us.listAll(curPage);
            request.setAttribute("pageBean", pageBean);
            rd=request.getRequestDispatcher("/listAll.jsp");
			rd.forward(request, response);
		}else if(path.equals("/top")){
			//排行榜的显示，下载文件最高的前10位
			List top=us.topList();
			request.setAttribute("top", top);
            rd=request.getRequestDispatcher("/topList.jsp");
			rd.forward(request, response);	
		}else if(path.equals("/show")){
			//显示单个文件的具体信息
			String id=request.getParameter("id");
			Map file=us.getById(id);
			request.setAttribute("file", file);
            rd=request.getRequestDispatcher("/showFile.jsp");
			rd.forward(request, response);
		}else if(path.equals("/sort")){
			//分类显示，带分页功能。
			String type=request.getParameter("type");
			//所有文件显示功能，带分页处理。
			// 获得要显示的页数
			String page = request.getParameter("page");
			// 当前的页数
			int curPage = 0; 
			//没有获得page值的处理
			if (page == null || page.length() < 1) { 
				curPage = 1;
			} else {
				curPage = Integer.parseInt(page);
			}
            PageBean pageBean=us.listSort(type,curPage);
            request.setAttribute("pageBean", pageBean);
            rd=request.getRequestDispatcher("/sortList.jsp");
			rd.forward(request, response);
		}else if(path.equals("/search")){
			//分类搜索，带分页功能。搜索条件为类别+文件说明中的关键字
			String type=request.getParameter("type");
			String name=request.getParameter("name");
			// 获得要显示的页数
			String page = request.getParameter("page");
			// 当前的页数
			int curPage = 0; 
			//没有获得page值的处理
			if (page == null || page.length() < 1) { 
				curPage = 1;
			} else {
				curPage = Integer.parseInt(page);
			}
            PageBean pageBean=us.search(type,name,curPage);
            request.setAttribute("pageBean", pageBean);
            rd=request.getRequestDispatcher("/searchList.jsp");
			rd.forward(request, response);
		}
	}
}
