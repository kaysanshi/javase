package com.zcib.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zcib.service.VideoService;

/**
 * Servlet implementation class PlayVideoServlet
 */
@WebServlet(description = "视频播放", urlPatterns = { "/teacher/PlayVideoServlet" , "/student/PlayVideoServlet","/addmin/PlayVideoServlet"})
public class PlayVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayVideoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//
		//获得项目名
				String requestPath1=request.getContextPath();
				int star=requestPath1.length();
				System.out.println(star);
				//获取请求的路径
				String requestpath=request.getRequestURI();
				System.out.println(requestpath);
				int i=requestpath.lastIndexOf("/");
				System.out.println(i);
				//获取请求的是哪一个
				String path=requestpath.substring(star,i);
				System.out.println(path);
		//
		String videoid=request.getParameter("videoid");
		VideoService service =new VideoService();
		List<Map<String,Object>> list=service.getVideo(videoid);
		System.out.println(list.toString());
		if (list.size()>0) {
			System.out.println("可以查询到");
			response.setContentType(this.getServletContext().getMimeType((String)list.get(0).get("uuidname")));
//			String filePath = "http://localhost:8080/SafeDemo/WEB-INF/upload/"+r.getUuidname();
			//可以
			String basePath = request.getScheme()+"://"
					+request.getServerName()+":"+request.getServerPort()+request.getContextPath() + (String)list.get(0).get("savepath")+"/"+(String)list.get(0).get("uuidname");
//			System.out.println(filePath);
			System.out.println(basePath);
			request.setAttribute("filepath", basePath);
			if (path.equals("/student")) {
				request.getRequestDispatcher("/student/playVideo.jsp").forward(request, response);
			}else if(path.equals("/teacher")){
				request.getRequestDispatcher("/teacher/playVideo.jsp").forward(request, response);
			}
			else if(path.equals("/addmin")){
				request.getRequestDispatcher("/addmin/playvideo.jsp").forward(request, response);
			}
		}else{
			System.out.println("未能够得到");
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
