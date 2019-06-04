package com.zcib.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zcib.domain.Video;
import com.zcib.factory.BasicFactory;
import com.zcib.service.VideoService;
import com.zcib.utils.DaoUtils;
/**
 *
 */
/**
 * Servlet implementation class DownListServlet
 */
/**
 * 上传列表
 * @author 555
 *
 */
@WebServlet(description = "视频列表", urlPatterns = { "/DownVideoListServlet" })
public class DownVideoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownVideoListServlet() {
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
				List<Video> list=service.getAllVideo();
				//2.
				request.setAttribute("list", list);
				request.getRequestDispatcher("/playvideo/videolist.jsp").forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
