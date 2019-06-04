package com.zcib.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.zcib.domain.User;
import com.zcib.factory.BasicFactory;
import com.zcib.service.UserService;
import com.zcib.utils.MD5Utils;

/**
 * Servlet implementation class RegistServlet
 */
/**
 * 注册
 * @author 555
 *
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserService service = BasicFactory.getFactory().GetInstance(UserService.class);
		try{
			//1.
			String valistr1 = request.getParameter("valistr");
			String valistr2 = (String) request.getSession().getAttribute("valistrt");
			if(valistr1 == null || valistr2 == null || !valistr1.equals(valistr2)){
				System.out.println(valistr1);
				System.out.println(valistr2);
				request.setAttribute("msg", "<font color='red'>输入有误</font>");
				request.getRequestDispatcher("/user/regist.jsp").forward(request, response);
				return;
			}
			//2.
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());	
			user.setPassword(MD5Utils.md5(user.getPassword()));
			//3.
			service.regist(user);
			
			//4.
			response.getWriter().write("注册成功！请稍等...");
			String url=request.getContextPath()+"/index.jsp";
			response.setHeader("Refresh", "3;url="+url);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
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
