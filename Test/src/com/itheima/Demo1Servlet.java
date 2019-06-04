package com.itheima;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ���servlet�̰߳�ȫ����:
 * �̳�SingleThreadModelʱ������������ʱ��ش���һ������
 * ����õķ�ʽ�ǲ������Servletʵ�����󣬲�����ÿ���̷ֱ߳����һ��������Servletʵ������
 * ���ǲ�û�н���̰߳�ȫ����;
 * 
 * ���յĽ����������:�������������,��̬����,����еĻ�����:
 * ����һ������¶����ü����ķ�ʽ,Ч�ʵ�
 */
//�������仰��������xml����д��ӳ��mapping
@WebServlet("/Demo1Servlet")
public class Demo1Servlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
       int i=0;
    public Demo1Servlet() {
        super();
        
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		synchronized (this) {
			i++;
				try {
					Thread.sleep(4*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			response.getWriter().write(i+"");
		}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
	}

}
