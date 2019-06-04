package com.itheima.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
//一个工具类
public class JDBCUtils {
	private static Properties prop = null;
	private JDBCUtils() {
	}
	static{
		try{
			prop = new Properties();
			prop.load(new FileReader(JDBCUtils.class.getClassLoader().getResource("config.properties").getPath()));
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 获取连接
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static Connection getConn() throws ClassNotFoundException, SQLException{
		// 1.注册数据库驱动
		Class.forName(prop.getProperty("driver"));
		// 2.获取连接
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));
		
	}
	/**
	 * 关闭连接
	 */
	public static void close(ResultSet rs, Statement stat,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				rs = null;
			}
		}
		if(stat!=null){
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				stat = null;
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				conn = null;
			}
		}
	
	}
}
