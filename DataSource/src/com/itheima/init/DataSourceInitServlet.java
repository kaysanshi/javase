package com.itheima.init;
///tomcat����������Դ�ķ�ʽ��
//context.xml��Ҫ��д�����ļ���Ȼ������init������ͨ��tomact��һ��java:comp/envȥ�ҵ�jndi��������ȡ����Դ

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class DataSourceInitServlet
 */
@WebServlet("/DataSourceInitServlet")
public class DataSourceInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataSourceInitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	@Override
	public void init() throws ServletException {
		try{
			//ͨ�������������
			Context initCtx = new InitialContext();
			//ͨ�������е�java:comp/envȥ��jndi
			Context jndi = (Context) initCtx.lookup("java:comp/env");
			//jndiȥ�����õ�����Դ��
			DataSource source = (DataSource) jndi.lookup("mySource");
			//ͨ���ҵ�������Դ��ȡ����
			Connection conn = source.getConnection();
			//��ȡ���Ӻ���ִ��sql��䣻
			PreparedStatement ps = conn.prepareStatement("select * from account");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				String name = rs.getString("name");
				System.out.println(name);
			}
			rs.close();
			ps.close();
			conn.close();
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
