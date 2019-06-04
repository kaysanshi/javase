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
//�����ӳؾ�������Դ
//�������������ܳ�ʼ��һ��������ʵ�õ�ʱ���Լ�ȥ�ҿ�Ԫ�ľͿ��ԣ�
//dbcp,c3p0,tomcat����Դ��
public class MyPool implements DataSource {
	private static List<Connection> pool=new LinkedList<>();
	static{
		//������������ִ�У�
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
		
		//--���ö�̬�������close����
		//proxy��������������ʵ��
		Connection proxy = (Connection) Proxy.newProxyInstance(conn.getClass().getClassLoader(), conn.getClass().getInterfaces()
			, new InvocationHandler(){
				//�������
				public Object invoke(Object proxy, Method method,
						Object[] args) throws Throwable {
					if("close".equals(method.getName())){
						//������Ҫ�����close����,�����Լ�д
						retConn(conn);
						return null;
					}else{
						//���ڲ������ķ������ñ�������������ͬ�ķ���
						return method.invoke(conn, args);
					}
				}
			
		});
		System.out.println("��ȡ��һ������,���ﻹʣ��"+pool.size()+"������");
		return proxy;
	
	
	}
	//
	protected void retConn(Connection conn) {
		// TODO Auto-generated method stub
		try {
			if(conn!=null && !conn.isClosed()){
				pool.add(conn);
				System.out.println("������һ������,���ﻹʣ��"+pool.size()+"������");
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
