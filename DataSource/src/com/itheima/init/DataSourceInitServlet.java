package com.itheima.init;
///tomcat中配置数据源的方式：
//context.xml需要书写配置文件，然后再在init方法中通过tomact的一个java:comp/env去找到jndi容器，获取数据源

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
			//通过穿件这个容器
			Context initCtx = new InitialContext();
			//通过容器中的java:comp/env去找jndi
			Context jndi = (Context) initCtx.lookup("java:comp/env");
			//jndi去找配置的数据源；
			DataSource source = (DataSource) jndi.lookup("mySource");
			//通过找到的数据源获取连接
			Connection conn = source.getConnection();
			//获取连接后开是执行sql语句；
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
