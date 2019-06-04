package servlets;

import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.AdminService;
import util.FileUtil;
import util.PageBean;

@WebServlet("/as/*")
public class AdminServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
	public AdminServlet() {
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
		AdminService as=new AdminService();
		if(path.equals("/add")){
			//处理添加文件的操作，包括上传文件和把文件信息写入数据库
			String uploadPath="/software";
			FileUtil fu=new FileUtil();
			int r=fu.upload(request, uploadPath);
			//操作成功或失败后返回结果页面result.jsp
			if(r==1 && as.add(fu.getFile(),fu.getParameters())==1){
				request.setAttribute("result", "添加成功！");
			}else{
				request.setAttribute("result", "添加失败！");
			}
			rd=request.getRequestDispatcher("/admin/result.jsp");
			rd.forward(request, response);
		}else if(path.equals("/update")){
			//更新文件时，显示待更新的文件信息
			String id=request.getParameter("id");
			Map file=as.getById(id);
			request.setAttribute("file", file);
			rd=request.getRequestDispatcher("/admin/update.jsp");
			rd.forward(request, response);
		}else if(path.equals("/dealUpdate")){
			//处理更新操作，更新分两个部分，更新上传文件和更新文件信息。
			int result=0;
			String uploadPath="/software";
			FileUtil fu=new FileUtil();
			int r=fu.upload(request, uploadPath);
			if(r==1){
			  Map file=(Map)fu.getFile();
			  Map parameters=(Map)fu.getParameters();
			  if(!file.isEmpty()){
				//更新上传文件
				//取得原有上传文件的绝对路径
				String realPath=this.getServletContext().getRealPath((String)parameters.get("filePath"));
				//删除原有文件，并更新数据库中的文件路径和文件名。
				result=as.updateFile(realPath,file,parameters);
			  }
			  //更新文件信息
			  result=as.updateInfo(parameters);
			}
			//操作成功或失败后返回结果页面result.jsp
			if(result==1){
				request.setAttribute("result", "更新成功！");
			}else{
				request.setAttribute("result", "更新失败！");
			}
			rd=request.getRequestDispatcher("/admin/result.jsp");
			rd.forward(request, response);
			
		}else if(path.equals("/delete")){
			//删除上传文件及其信息，留给读者实现
			
		}else if(path.equals("/list")){
			//文件显示功能，带分页处理。
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
            PageBean pageBean=as.list(curPage);
            request.setAttribute("pageBean", pageBean);
            rd=request.getRequestDispatcher("/admin/list.jsp");
			rd.forward(request, response);
		}
	}
}
