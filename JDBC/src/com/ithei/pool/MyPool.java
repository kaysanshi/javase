package com.ithei.pool;

import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;
//用连接池就是数据源
//程序已启动就能初始化一批连接其实用的时候自己去找开元的就可以：
//dbcp,c3p0,tomcat数据源；
public class MyPool implements DataSource {
	private static List<Connection> pool=new LinkedList<>();
	static{
		//程序已启动就执行；
		try {
			Class.forName("com.mysql.jdbac.Driver");
			for(int i=0;i<5;i++){
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blob","root","123");
				pool.add(conn);
			}
		} catch (ClassNotFoundException | SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		if(pool.size()==0){
			for(int i=0;i<3;i++){
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blob","root","123");
				pool.add(conn);
			}
		}
		final Connection conn = pool.remove(0);
		
		//--利用动态代理改造close方法
		//proxy类用于生产代理实例
		Connection proxy = (Connection) Proxy.newProxyInstance(conn.getClass().getClassLoader(), conn.getClass().getInterfaces()
			, new InvocationHandler(){
				//代理对象
				public Object invoke(Object proxy, Method method,
						Object[] args) throws Throwable {
					if("close".equals(method.getName())){
						//对于想要改造的close方法,我们自己写
						retConn(conn);
						return null;
					}else{
						//对于不想改造的方法调用被代理者身上相同的方法
						return method.invoke(conn, args);
					}
				}
			
		});
		System.out.println("获取了一个连接,池里还剩余"+pool.size()+"个连接");
		return proxy;
	
	
	}
	//
	protected void retConn(Connection conn) {
		// TODO Auto-generated method stub
		try {
			if(conn!=null && !conn.isClosed()){
				pool.add(conn);
				System.out.println("还回了一个连接,池里还剩余"+pool.size()+"个连接");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
