package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.AdminService;

@WebServlet("/ls")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
	public LoginServlet() {
        super();
    }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("GBK");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		RequestDispatcher rd=null;
		if(username!=null && password!=null){
			AdminService as=new AdminService();
			//验证登录用户名密码是否正确
			if(as.checkLogin(username, password)){
				request.getSession().setAttribute("login", "ok");
				rd=request.getRequestDispatcher("/as/list");
				rd.forward(request, response);
				return;
			}
		}
		//当用户名或密码为null，或者用户名密码不正确时，返回登录页面，并给出提示信息。
		rd=request.getRequestDispatcher("/admin/login.jsp?error=yes");
		rd.forward(request, response);
	}
}
