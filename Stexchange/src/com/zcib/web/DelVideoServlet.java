package com.zcib.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zcib.service.VideoService;

/**
 * Servlet implementation class DelVideoServlet
 */
@WebServlet("/teacher/DelVideoServlet")
public class DelVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelVideoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获得要删除的id
			String id=request.getParameter("videoid");
			System.out.println("获取到的视频id："+id);
			VideoService service=new VideoService();
			boolean status=service.delteVideo(id);
			if(status==true){
				response.getWriter().write("1");
				System.out.println("删除成功");
			}else{
				response.getWriter().write("0");
				System.out.println("删除失败");
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
