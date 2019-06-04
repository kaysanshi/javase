package com.zcib.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zcib.domain.Video;
import com.zcib.factory.BasicFactory;
import com.zcib.service.VideoService;

/**
 * Servlet implementation class GetPlayServlet
 */
/**
 * 随机获取视频
 * @author 555
 *
 */
@WebServlet("/GetPlayServlet")
public class GetPlayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPlayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		VideoService service=BasicFactory.getFactory().GetInstance(VideoService.class);
		//1.
		List<Video> list=service.getRedomVideo();
		//2.请求转发
		request.setAttribute("list", list);
		request.getRequestDispatcher("/playvideo/videolearn.jsp").forward(request, response);	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
