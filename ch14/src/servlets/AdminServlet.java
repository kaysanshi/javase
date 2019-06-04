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
		//�����ļ�·��������·�����в�ͬ�Ĵ���
		String requestPath=request.getRequestURI();
		int i=requestPath.lastIndexOf('/');
		String path=requestPath.substring(i);
		RequestDispatcher rd=null;
		//����ģ�Ͳ����
		AdminService as=new AdminService();
		if(path.equals("/add")){
			//��������ļ��Ĳ����������ϴ��ļ��Ͱ��ļ���Ϣд�����ݿ�
			String uploadPath="/software";
			FileUtil fu=new FileUtil();
			int r=fu.upload(request, uploadPath);
			//�����ɹ���ʧ�ܺ󷵻ؽ��ҳ��result.jsp
			if(r==1 && as.add(fu.getFile(),fu.getParameters())==1){
				request.setAttribute("result", "��ӳɹ���");
			}else{
				request.setAttribute("result", "���ʧ�ܣ�");
			}
			rd=request.getRequestDispatcher("/admin/result.jsp");
			rd.forward(request, response);
		}else if(path.equals("/update")){
			//�����ļ�ʱ����ʾ�����µ��ļ���Ϣ
			String id=request.getParameter("id");
			Map file=as.getById(id);
			request.setAttribute("file", file);
			rd=request.getRequestDispatcher("/admin/update.jsp");
			rd.forward(request, response);
		}else if(path.equals("/dealUpdate")){
			//������²��������·��������֣������ϴ��ļ��͸����ļ���Ϣ��
			int result=0;
			String uploadPath="/software";
			FileUtil fu=new FileUtil();
			int r=fu.upload(request, uploadPath);
			if(r==1){
			  Map file=(Map)fu.getFile();
			  Map parameters=(Map)fu.getParameters();
			  if(!file.isEmpty()){
				//�����ϴ��ļ�
				//ȡ��ԭ���ϴ��ļ��ľ���·��
				String realPath=this.getServletContext().getRealPath((String)parameters.get("filePath"));
				//ɾ��ԭ���ļ������������ݿ��е��ļ�·�����ļ�����
				result=as.updateFile(realPath,file,parameters);
			  }
			  //�����ļ���Ϣ
			  result=as.updateInfo(parameters);
			}
			//�����ɹ���ʧ�ܺ󷵻ؽ��ҳ��result.jsp
			if(result==1){
				request.setAttribute("result", "���³ɹ���");
			}else{
				request.setAttribute("result", "����ʧ�ܣ�");
			}
			rd=request.getRequestDispatcher("/admin/result.jsp");
			rd.forward(request, response);
			
		}else if(path.equals("/delete")){
			//ɾ���ϴ��ļ�������Ϣ����������ʵ��
			
		}else if(path.equals("/list")){
			//�ļ���ʾ���ܣ�����ҳ����
			// ���Ҫ��ʾ��ҳ��
			String page = request.getParameter("page");
			// ��ǰ��ҳ��
			int curPage = 0; 
			//û�л��pageֵ�Ĵ���
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
