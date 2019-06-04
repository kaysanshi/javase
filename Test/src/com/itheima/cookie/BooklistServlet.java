package com.itheima.cookie;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Book;

/**
 * Servlet implementation class BooklistServlet
 */
@WebServlet("/BooklistServlet")
public class BooklistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BooklistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		//查询数据库中的书的展示：
		Map<String, Book> map=BookDao.getbooks();
		for (Map.Entry<String, Book>entry :map.entrySet()) {
			Book book =entry.getValue();
			response.getWriter().write("<a href='"+request.getContextPath()+"/BookInfoServlet?id="+book.getId()+"'>"+book.getName()+"</a><br>");
		}
		response.getWriter().write("<hr>");
		//2`显示之前看过的书
		Cookie[] cookies=request.getCookies();
		Cookie findC=null;
		if(cookies!=null){
		for(Cookie c :cookies){
			if("last".equals(c.getName())){
				findC=c;
			}
		}
		}
		if(findC==null){
			response.getWriter().write("你未浏览过");
		}else{
			response.getWriter().write("你浏览过书有："+"<br/>");
			//cookies是返回一个long行的值
			String[] ids=findC.getValue().split(",");
			for(String id :ids){
				Book book=BookDao.getbook(id);
				//response.getWriter().write(book.getName()+"<br/>");
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
