package com.zcib.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zcib.domain.Video;
import com.zcib.factory.BasicFactory;
import com.zcib.service.VideoService;
/**
 * Servlet implementation class PlayServlet
 */
/**
 * 视频播放通用
 * @author 555
 *
 */
@WebServlet(description = "视频播放", urlPatterns = { "/PlayServlet" })
public class PlayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayServlet() {
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
		String id = request.getParameter("id");
		
		//2.
		Video r=service.getVideo(id);
		if(r==null){
	
			response.getWriter().write("未找到资源!!!");
			return;
		}else{
			
			response.setContentType(this.getServletContext().getMimeType(r.getRealname()));
//			String filePath = "http://localhost:8080/SafeDemo/WEB-INF/upload/"+r.getUuidname();
			//可以
			String basePath = request.getScheme()+"://"
					+request.getServerName()+":"+request.getServerPort()+request.getContextPath() + r.getSavepath()+"/"+r.getUuidname();
//			System.out.println(filePath);
			request.setAttribute("filepath", basePath);
			System.out.println(basePath);
			request.getRequestDispatcher("playvideo/videolearn.jsp").forward(request, response);
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
