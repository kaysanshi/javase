package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/ls")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		RequestDispatcher rd=null;
		if(username!=null && password!=null){
			AdminService as=new AdminService();
			//��֤��¼�û��������Ƿ���ȷ
			if(as.checkLogin(username, password)){
				request.getSession().setAttribute("login", "ok");
				rd=request.getRequestDispatcher("/as/list");
				rd.forward(request, response);
				return;
			}
		}
		//���û���������Ϊnull�������û������벻��ȷʱ�����ص�¼ҳ�棬��������ʾ��Ϣ��
		rd=request.getRequestDispatcher("/admin/login.jsp?error=yes");
		rd.forward(request, response);
		
	
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
