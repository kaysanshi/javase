package com.mingribook.Upload;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;

//����jspSmartUpload����ϴ��ļ�
/**  
 * Servlet implementation class UpLoadServlet
 */

@WebServlet("/upload")

public class UpLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpLoadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<HTML>");
		out.println("<BODY>");
		out.println("<H3>jspSmartUpload:Servlet Sample</H3>");
		out.println("<hr>");
		//��smartupload�ദ��
		SmartUpload mSmartUpload=new SmartUpload();
		//�ϴ��ļ�������
		int count=0;
		
		try {
			mSmartUpload.initialize(this.getServletConfig(), request, response);
			//����ÿ���ļ�����󳤶�
			mSmartUpload.setMaxFileSize(50*1024*1024);
			//�趨�����ϴ����ļ���������doc,text,�ļ�
			mSmartUpload.setAllowedFilesList("doc,txt");
			mSmartUpload.upload();
			//����ϴ��ļ�
			File file=mSmartUpload.getFiles().getFile(0);
			//����ϴ��ļ�������
			String fname=file.getFileName();
			//�ļ��ı���Ŀ¼
			
			count =mSmartUpload.save("/WEB-INF/upload");
			//����ļ���������Ϣ
			Request re=mSmartUpload.getRequest();
			String desc=re.getParameter("desc");
			out.println(count+"file uploaded.<br>");
			out.println("file description :"+desc);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("Unable to upload the File<br>");
			out.println("Error:"+e.toString());
		}
		out.println("</BODY>");
		out.println("</HTML>");
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
