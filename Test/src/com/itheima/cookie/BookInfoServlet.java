package com.itheima.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Book;

/**
 * Servlet implementation class BookInfoServlet
 */
@WebServlet("/BookInfoServlet")
public class BookInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
	//1.��ȡҪ�������id����ѯ���ݿ��ҳ������Ϣ��Ϣ��
		String id=request.getParameter("id");
		Book book=BookDao.getbook(id);
		if(book==null){
			response.getWriter().write("�Ҳ����Ȿ��");
			return;
		}else{
			response.getWriter().write("<h1>������"+book.getName()+"</h1>");
			response.getWriter().write("<h1>���ߣ�"+book.getAuthor()+"</h1>");
			response.getWriter().write("<h1>�۸�"+book.getPrice()+"</h1>");
			response.getWriter().write("<h1>�����磺"+book.getPublish()+"</h1>");
			response.getWriter().write("<h1>������"+book.getDiscrible()+"</h1>");
		}
	//2.����cookie���浽������еĿ������飻
		
		Cookie[] cookies=request.getCookies();
		Cookie findC=null;
		String ids=null;
		if(cookies!=null){
		for(Cookie c :cookies){
			if("last".equals(c.getName())){
				findC=c;
				}
			}
		}
		if(findC==null){
			//˵��û�п�������
			ids+=book.getId();
		}else{
			//˵��ԭ�ȿ����飻
			String[] olds=findC.getValue().split(",");
			StringBuffer buffer=new StringBuffer();
			buffer.append(book.getId()+"");
			for(int i=0;i<buffer.length()&& buffer.toString().split(",").length<3;i++){
				String old=olds[i];
				if(!old.equals(book.getId())){
					buffer.append(old+",");
				}
			}
			ids=buffer.substring(0,buffer.length()-1);
		}
		//
		Cookie lastC=new Cookie("last", ids);
		lastC.setMaxAge(3600*24*30);
		lastC.setPath(request.getContextPath());
		response.addCookie(lastC);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
