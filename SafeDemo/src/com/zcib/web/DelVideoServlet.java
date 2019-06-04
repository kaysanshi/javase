package com.zcib.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.zcib.domain.Video;
import com.zcib.domain.User;
import com.zcib.factory.BasicFactory;
import com.zcib.service.VideoService;

/**
 * Servlet implementation class DelResourceServlet
 */
/**
 * 删除资源
 * @author 555
 *
 */
@WebServlet(description = "删除视频", urlPatterns = { "/addmin/DelVideoServlet" })
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
	VideoService service =BasicFactory.getFactory().GetInstance(VideoService.class);
	String videoid=request.getParameter("videoid");
	
	Video  video=new Video();
	video.setId(Integer.parseInt(videoid));
	try {
		BeanUtils.populate(video, request.getParameterMap());
		
	} catch (IllegalAccessException | InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		boolean status=service.delVideo(video);
		if (status==true) {
			response.getWriter().write("1");
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
