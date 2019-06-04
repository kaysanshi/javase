package com.itheima.cookie;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * cookie��Cookie�ǿͻ��˼����������ÿ���û���������cookie����ʽ
 * д���û����Ե�����������û�ʹ���������ȥ���ʷ������е�web��Դʱ��
ȥ��������web��Դ����ľ����û����Ե������ˡ�

 */
/**
 * Servlet implementation class CookieDemo1
 */
@WebServlet("/CookieDemo1")
public class CookieDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieDemo1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		
		//����cookie����
		Cookie[] cookies=request.getCookies();
		Cookie findC=null;
		if(cookies!=null){
		for(Cookie c :cookies){
			if("lasttime".equals(c.getName())){
				findC=c;
			}
		}
		}
		if(findC==null){
			response.getWriter().write("���ǵ�һ�η��������վ");
		}else{
			//cookies�Ƿ���һ��long�е�ֵ
			Long lastTime=Long.parseLong(findC.getValue());
			response.getWriter().write("���ϴη��ʵ�ʱ���ǣ�"+new Date(lastTime).toLocaleString());
		}
		
		Date date=new Date();
		Cookie cookie=new Cookie("lasttime", date.getTime()+"");
		//����cookies��������ʱ��
		//�൱��response�������һ��Set-cookie����Ӧͷ
		cookie.setMaxAge(36000);
		//��������webӦ�õ�cookie��Ϣ�����Դ���ȥ��
		cookie.setPath(request.getContextPath());
		response.addCookie(cookie);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
