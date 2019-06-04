package com.itheima;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo7Servlet
 */
//��ȡ��Դ�ļ�
@WebServlet("/Demo7Servlet")
public class Demo7Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Demo7Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��������д���ᵽ��ǰ������Ŀ¼�������ַ;���ǿ����þ���·��ȥѰ�ҵ��Ƿ�����ʱ����д���
		//�������·������·��������;
//		File file=new File("config.properties");
//		System.out.println(file.getAbsolutePath());
		///���������µķ�����д
		//��myeclipes���������õ�����eclipes��ȴ��������???
		//eclipes�������ַŷ�;
		Properties prop=new Properties();
		prop.load((this.getServletContext().getResourceAsStream("/WEB-INF/config.properties")));
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
