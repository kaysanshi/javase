package com.itheima.response;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OutServlet
 */
/**
 * 
 * ��������������Ϣ
 *
 */
@WebServlet("/OutServlet")
public class OutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//������һ���������,�õ��ǲ���ϵͳ�ı���GBK;
		//�������ʱҲ��GBK�Ĵ򿪷�ʽ����û������
		//response.getOutputStream().write("English very so easy".getBytes());
		//���ǻ��������,��Ҫ�������Ҳʹ��Utf-8����򿪲Ų����������������ķ���
		//response.setHeader("Content-Type", "text/html;charset=utf-8");
		//response.getOutputStream().write("�й�".getBytes("utf-8"));
		/*��ʱ�������ֻ�������ʱ��ֻ���Ƿ������Ѻ���ת��Ϊ010101Ȼ��ȥ��iso8859-1���
		��������û������,�����iso8859-1�Ҳ����Ļ��ᱻת��Ϊ?,Ȼ��������ֻ���GBK������������Ի���ʾ??
		��ʱҪָ��������������
		*/
		//ָ��������������
		response.setCharacterEncoding("gbk");
		response.getWriter().write("beijiang");
		response.getWriter().write("�й�");
		//��������;
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write("�й�");
		//��������;setContentType����ֱ��ָ��������ͷ������ı��뷽ʽ
		response.setContentType("text/html,charset=utf-8");
		response.getWriter().write("�й�");
		//��������SetCharacterEncondingָ���������ı���
		//setContentTypeָ��������ı���
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html,charset=utf-8");
		response.getWriter().write("�й�");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
