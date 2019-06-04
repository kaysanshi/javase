package com.itheima.response;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownServlet
 */
/*
 * servlet�е�response���صĹ���
 */
@WebServlet("/DownServlet")
public class DownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		///���ص���ʽӦ���������ʽ(Y)
		//setHeaderͷ��Ϣ��֧�����ĸ�ʽ������������������������������ָ������������ʾ������
		//response.setHeader("Content-Disposition", "attachment;filename=��Ů.jpg");
		//��ʽһ:����
		//response.setHeader("Content-Disposition", "attachment;filename=butiful.jpg");
		//�����ʽ��:url���������ascII���е�ת��Ϊurl����Ȼ����ת��Ϊָ���ı���
		response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode("��Ů.jpg","utf-8"));
		//����ֻ�Ƕ�ȡ���������ļ����ǲ�û��ʵ�����ع���(N)
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public static void main(String[] args) throws UnsupportedEncodingException {
		String string="�й�";
		//ʹ���ض��ı��뷽�����ַ���ת��Ϊ application/x-www-form-urlencoded��ʽ�� 
		String str2=URLEncoder.encode(string,"utf-8");
		System.out.println(str2);
		//ʹ���ض��ı��뷽������ application/x-www-form-urlencoded�ַ�����
		//��url��������utf-8����ʽ
		String str3=URLDecoder.decode("%E4%B8%AD%E5%9B%BD","utf-8");
		System.out.println(str3);
	}
}
