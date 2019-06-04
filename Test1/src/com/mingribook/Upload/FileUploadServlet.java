package com.mingribook.Upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
//�ļ��ϴ�
/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/fileupload")

public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
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
		out.println("<H3>FileUpload:Servlet Sample</H3>");
		out.println("<hr>");
		try{
			//ʵ��һ��Ӳ���ļ��������������ϴ����servletFileUpload
			DiskFileItemFactory factory=new DiskFileItemFactory();
			//���û������Ĵ�С4kb
			factory.setSizeThreshold(4096);
			//ʵ�����ϴ����
			ServletFileUpload upload=new ServletFileUpload(factory);
			//�����ϴ����ļ��ĳߴ�
			upload.setSizeMax(4194304);
			//�����ϴ���ַ
			String uploadPath=this.getServletContext().getRealPath("/WEB-INF/upload");
			//����request����
			FileItemIterator fii= upload.getItemIterator(request);
			//��������
			while(fii.hasNext()){
				//�õ���ǰ���ļ���
				FileItemStream fis=fii.next();
				//��鵱ǰ��Ŀ����ͨ�������ļ��ϴ�
				if (fis.isFormField()) {
					//��ʾ��
					if("desc".equals(fis.getFieldName())){
						out.println("file description:"+fis.getFieldName()+"<br/>");
					}
					
				}else{
					//�����ļ�
					//�õ��ļ���·��
					String  path=fis.getName();
					//�õ������ļ�·��������
					String  filename=path.substring(path.lastIndexOf("\\")+1);
					//���ļ����浽webĿ¼�µ�upload�ļ�����
					BufferedInputStream bis=new BufferedInputStream(fis.openStream());
					BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(new File(uploadPath+"\\"+filename)));
					//���ļ�д��ָ�����ļ��ϴ�
					Streams.copy(bis, bos, true);
					out.println(filename+"file upload.<br/>");
				}
			}
		}catch(FileUploadException e){}
		out.println("</BODY>");
		out.println("</HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
