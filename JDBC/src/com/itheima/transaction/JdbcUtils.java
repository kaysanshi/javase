package com.itheima.transaction;

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

//创建一个带事务的类；
public class JdbcUtils {
	private static String driver;
	private static String url;
	private static String name;
	private static String password;
	/**
	 * 它为null表示没有事务
	 * 它不为null表示有事务
	 * 当开启事务时，需要给它赋值
	 * 当结束事务时，需要给它赋值为null
	 * 并且在开启事务时，让dao的多个方法共享这个Connection
	 */
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();//事务专用
	
	//此静态模块在类被加载时执行，且只被执行一次
	static{
		//从配置文件中读取参数值
		InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("config.properties");
		Properties props = new Properties();
		try {
			props.load(in);
			driver = props.getProperty("driverClassName");
			url = props.getProperty("url");
			name = props.getProperty("name");
			password = props.getProperty("password");
			//加载驱动程序
			Class.forName(driver);
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e.getMessage());
		}
	}
	
	//获取数据库连接
	public static Connection getConnection() throws SQLException{
		/*
		 * 如果有事务，且tl中已经有连接，则返回当前事务tl的conn
		 * 如果有事务，tl中没有连接，则生成一个新的连接返回
		 * 如果没有事务，生成一个新的连接返回。
		 */
		Connection conn = tl.get();//获取当前线程的事务连接
		if(conn!=null)
			return conn;
		return DriverManager.getConnection(url,name,password);
	}
	
	//释放连接
	public static void release(Connection conn,Statement stmt,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage(),e);
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage(),e);
			}
		}
		//如果是事务，则不关闭数据库连接（在事务的提交或回滚中关闭）
		Connection transConn = tl.get();//有事务
		if(transConn==conn){//要关闭的是事务的连接
			return;
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage(),e);
			}
		}
	}
	
	
	/*
	 * 开启事务
	 * 使用事务，需在开启事务方法中获取数据库的连接，且规定只在事务开启前中获取数据库连接
	 * 其它地方获取均为错误
	 */
	public static void beginTransaction() throws SQLException{
		//获取tl中的数据库连接
		Connection conn = tl.get();
		//如果tl中已经有了数据库连接，则说明已经开启过事务
		if(conn!=null)
			throw new SQLException("已经开启过事务，请勿重复开启！");
		conn = getConnection();//获取数据库连接
		conn.setAutoCommit(false);//设置为手动提交
		tl.set(conn);//将获取的数据库连接放入tl中，此时事务中已经有数据库连接
	}
	
	/*
	 * 提交事务
	 * 提交完事务，关闭数据库连接，且仅在事务提交和回滚中关闭数据库连接
	 * 不再其它地方进行关闭
	 */
	public static void commitTransaction() throws SQLException{
		Connection conn = tl.get();//获取当前线程中事务的数据库连接
		if(conn == null)
			throw new SQLException("没有事务，不能提交！");
		conn.commit();//提交事务
		conn.close();//关闭数据库连接
		conn = null;
		tl.remove();//将tl中的数据库连接移除
	}
	
	/*
	 * 回滚事务
	 * 事务出现异常，需要回滚，回滚完，关闭数据库连接
	 */
	public static void rollbackTransaction() throws SQLException{
		//获取当前线程中的数据库连接
		Connection conn = tl.get();
		//判断该连接是否存在
		if(conn == null)
			throw new SQLException("数据库连接不存在，不能进行回滚！");
		conn.rollback();//事务回滚
		conn.close();//关闭数据库连接
		conn = null;
		tl.remove();//将tl中的数据库连接移除
	}
	
	//进行增删改操作
	public static int update(String sql,Object... params) {
		Connection conn = null;
		PreparedStatement pre = null;
		
		try {
			/*
			 * 获取数据库连接
			 * 1.如果是事务，则在调用update方法之前，已经开启了事务，事务中已经有了连接
			 * 这里获取的连接就是事务中的连接，不再是新的连接
			 * 2.如果不是事务，这里的连接就会生成一个新的连接
			 */
			conn = getConnection();
			//获取PreparedStatment对象
			pre = conn.prepareStatement(sql);
			fillStatement(pre, params);
			return pre.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}finally{
			release(conn,pre,null);
		}
	}
	
	//添加操作，需要返回自增的主键
	public static Object  insert(String sql,Object... params) {
			Connection conn = null;
			PreparedStatement pre = null;
			ResultSet rs =  null;
			try {
				//获取数据库连接
				conn = getConnection();
				//获取PreparedStatment对象
				pre = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				//设置sql参数值
				fillStatement(pre, params);
				//执行sql语句
				pre.executeUpdate();
				//获取主键
				rs = pre.getGeneratedKeys();
				Object key = null;
				if(rs.next()){
					key = rs.getObject(1);
				}
				return key;
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage(),e);
			}finally{
				release(conn,pre,null);
			}
		}

	private static void fillStatement(PreparedStatement pre, Object... params)
			throws SQLException {
		if(params!=null){
			for(int i=0;i<params.length;i++){
				pre.setObject(i+1, params[i]);
			}
		}
	}
	
	public static List<Map<String,Object>>  select(String sql,Object... params) {
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		List<Map<String,Object>> list = null;
		try {
			//获取数据库连接
			conn = getConnection();
			//获取PreparedStatment对象
			pre = conn.prepareStatement(sql);
			fillStatement(pre, params);
			//执行sql语句
			rs = pre.executeQuery();
			list = RsToList(rs);
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}finally{
			release(conn,pre,null);
		}
	}

	private static List<Map<String, Object>> RsToList(ResultSet rs) throws SQLException {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		//获取表结构
		ResultSetMetaData rsmd = rs.getMetaData();
		while(rs.next()){
			Map<String,Object> map = new HashMap<String,Object>();
			for(int i=1;i<=rsmd.getColumnCount();i++){
				map.put(rsmd.getColumnName(i), rs.getObject(i));
			}
			list.add(map);
		}
		return list;
	}
	
	//批处理insert操作
	public static  List insertbatch(String sql, Object [][]params){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			pre = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			//设置参数
			if(params!=null){
				for(int i=0;i<params.length;i++){
					fillStatement(pre, params[i]);
						pre.addBatch();//添加到批处理中命令中
				}
			}
			pre.executeBatch();
			rs = pre.getGeneratedKeys();
			List list = new ArrayList();
			while(rs.next()){
				list.add(rs.getObject(1));
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			release(conn, pre, rs);
		}
		
	}
	
	//批处理update和delete操作
	//批处理insert操作
		public static int[] udpatebatch(String sql, Object [][]params){
			Connection conn = null;
			PreparedStatement pre = null;
			try {
				conn = JdbcUtils.getConnection();
				pre = conn.prepareStatement(sql);
				//设置参数
				if(params!=null){
					for(int i=0;i<params.length;i++){
						fillStatement(pre, params[i]);
							pre.addBatch();//添加到批处理中命令中
					}
				}
				return pre.executeBatch();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}finally{
				release(conn, pre, null);
			}
		}
		
			
}
