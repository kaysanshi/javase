package com.zcib.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class JDBCUtils {
	private static String driver ;
	private static String url ;
	private static String name ;
	private static String password ;
	
	//当类被加载时，会被执行一次，且只会执行一次
	static{
		try {
			Properties props = new Properties();
			InputStream in = JDBCUtils.class.getClassLoader()
					.getResourceAsStream("dbConfig.properties");
			props.load(in);
			driver = props.getProperty("driver");
			url = props.getProperty("url");
			name = props.getProperty("name");
			password = props.getProperty("password");
			Class.forName(driver);
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e.getMessage());
		}
	}
	
	//获取数据库的连接
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,name,password);
	}
	
	//关闭连接
	public static void release(Connection conn,Statement stmt,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//增加一条记录，用于返回自增的主键
	public static Object insert(String sql,Object...params){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		Object key = null;
		try {
			//获取数据库连接
			conn = JDBCUtils.getConnection();
			//获取Statement对象
			pre = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//设置参数值
			if(params!=null){
				for(int i=0;i<params.length;i++){
					pre.setObject(i+1,params[i]);
				}
			}
			//向数据库中插入一条记录
			pre.executeUpdate();
			//获取该条记录的主键
			rs = pre.getGeneratedKeys();
			if(rs.next()){
				key = rs.getInt(1);
			}
			return key;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(),e);
		}finally{
			release(conn,pre,rs);
		}
	}
	
	//修改、删除操作
	public static void update(String sql,Object... params){
		/*
		 * 向数据库添加一条新闻记录
		 */
		Connection conn = null;
		PreparedStatement pre = null;
		
		try {
			
			//获取连接
			
			conn = JDBCUtils.getConnection();
			//获取Statement对象
			
			pre = conn.prepareStatement(sql);
			//设置参数值
			if(params!=null){
				for(int i=0;i<params.length;i++){
					pre.setObject(i+1, params[i]);
				}
			}
			
			//向数据库中修改一条记录
			pre.executeUpdate();
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(),e);
		}finally{
			JDBCUtils.release(conn, pre, null);
		}
	}

	//查询
	public static List<Map<String,Object>> find(String sql,Object... params){
		/*
		 * 1.获取数据库连接
		 * 2.访问数据库（查询所有新闻）
		 * 3.将查询结果转换为List形式，返回
		 * 4.关闭连接
		 */
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		List<Map<String,Object>> list = null;
		try {
			
			//获取数据库连接
			conn = JDBCUtils.getConnection();
			//获取PreparedStatement对象
			pre = conn.prepareStatement(sql);
			//设置参数值
			if(params!=null){
				for(int i=0;i<params.length;i++){
					pre.setObject(i+1, params[i]);
				}
			}
			rs = pre.executeQuery();
			//将rs转换为List列表返回
			list = RSToList(rs);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			JDBCUtils.release(conn, pre, rs);
		}
		return list;
	}
	
	/*
	 * 将一个ResultSet对象转换为一个List<Map<String,Object>>对象
	 */
	private static List<Map<String,Object>> RSToList(ResultSet rs) throws SQLException{
		List<Map<String,Object>>  list = new ArrayList<Map<String,Object>>();
		ResultSetMetaData rsmd = rs.getMetaData();//获取表结构
		//逐条读出记录
		while(rs.next()){
			//创建一个Map对象
			Map<String,Object> map = new HashMap<String,Object>();
			for(int i=1;i<=rsmd.getColumnCount();i++){
				//表的字段名（rsmd.getColumnName(i)）为key，对应的值为value
				map.put(rsmd.getColumnName(i).toLowerCase(),rs.getObject(i));
			}
			list.add(map);//将这一条记录添加到list中
		}
		return list;
	}
}
