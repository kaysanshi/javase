package com.zcib.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.zcib.domain.Video;
import com.zcib.factory.BasicFactory;
import com.zcib.service.VideoService;
import com.zcib.utils.DaoUtils;
import com.zcib.utils.IOUtils;


/**
 * Servlet implementation class DowntServlet
 */
/**
 * 下载
 * @author 555
 *
 */
@WebServlet("/DowntServlet")
public class DowntServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DowntServlet() {
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
			//3.
			response.getWriter().write("资源未找到!!!");
			return;
		}else{
			//4.
			response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(r.getRealname(),"UTF-8"));
			response.setContentType(this.getServletContext().getMimeType(r.getRealname()));
			String filePath = this.getServletContext().getRealPath(r.getSavepath()+"/"+r.getUuidname());
			InputStream in = new FileInputStream(filePath);
			OutputStream out = response.getOutputStream();
			IOUtils.In2Out(in, out);
			IOUtils.close(in, null);
		}	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
