package com.itheima.response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CatchServlet
 */
/*
 * �����ʵ��
 */
@WebServlet("/CatchServlet")
public class CatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatchServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���û����ʱ��
		response.setDateHeader("Expires", System.currentTimeMillis()+1000L*3600*24*30);
		//����ֻ�Ƕ�ȡ���������ļ����ǲ�û��ʵ�����ع���
		InputStream in=new  FileInputStream(this.getServletContext().getRealPath("1.jpg"));
		OutputStream out=response.getOutputStream();
		byte[]bs=new byte[1024];
		int i=0;
		i=in.read(bs);
		while(i!=-1){
			out.write(bs,0,i);
			i=in.read(bs);
		}
		in.close();
		///���ص���ʽӦ���������ʽ
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
