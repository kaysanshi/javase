package com.zcib.web;

import java.io.File;
import java.io.IOException;import java.time.chrono.MinguoEra;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.zcib.domain.Video;
import com.zcib.service.VideoService;
import com.zcib.utils.FileUtils;
import com.zcib.utils.SimpleDate;

/**
 * Servlet implementation class UploadVideoServlet
 */
@WebServlet(description = "视频的上传", urlPatterns = { "/teacher/UploadVideoServlet" })
public class UploadVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//储存文件上传的信息
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadVideoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//设置缓存的
		String temp=this.getServletContext().getRealPath("WEB-INF/temp");
		//这是获取的是enctype的值Mime
		String mime=request.getContentType();
		System.out.println(mime);
		String teacheid=(String)request.getSession().getAttribute("id");
		//获取ip
		String ip=request.getRemoteAddr();
		//上传路径
		String uploadPath="/upload/video";
		VideoService service=new VideoService();
		////
		///////////
		FileUtils uploadvideo=new FileUtils();
			Video video=new Video();
			///上传
			int flag= uploadvideo.upload(request, uploadPath, temp);
			//获取文件的map对象
			Map<String, Object> file=uploadvideo.getFile();
			video.setSavepath(uploadPath);
			video.setDescription((String)file.get("description"));
			//获得文本域的文字
			System.out.println(":"+(String)file.get("description"));
			video.setUplaodteime(new SimpleDate().getdate());
			video.setUploadip((String) file.get("ip"));
			video.setUuidname((String)file.get("uuidname"));
			//upload
			video.setVideotitle((String)file.get("videotitle"));
			video.setUploadteacherid(Integer.parseInt(teacheid));
			if (flag==1) {
				boolean status=service.addvideo(video);
				if (status==true) {
					response.getWriter().write("1");
				}else{
					response.getWriter().write("0");
				}
			}else{
				System.out.println("文件类型错误");
				response.getWriter().write("00");
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
