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

//����һ����������ࣻ
public class JdbcUtils {
	private static String driver;
	private static String url;
	private static String name;
	private static String password;
	/**
	 * ��Ϊnull��ʾû������
	 * ����Ϊnull��ʾ������
	 * ����������ʱ����Ҫ������ֵ
	 * ����������ʱ����Ҫ������ֵΪnull
	 * �����ڿ�������ʱ����dao�Ķ�������������Connection
	 */
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();//����ר��
	
	//�˾�̬ģ�����౻����ʱִ�У���ֻ��ִ��һ��
	static{
		//�������ļ��ж�ȡ����ֵ
		InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("config.properties");
		Properties props = new Properties();
		try {
			props.load(in);
			driver = props.getProperty("driverClassName");
			url = props.getProperty("url");
			name = props.getProperty("name");
			password = props.getProperty("password");
			//������������
			Class.forName(driver);
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e.getMessage());
		}
	}
	
	//��ȡ���ݿ�����
	public static Connection getConnection() throws SQLException{
		/*
		 * �����������tl���Ѿ������ӣ��򷵻ص�ǰ����tl��conn
		 * ���������tl��û�����ӣ�������һ���µ����ӷ���
		 * ���û����������һ���µ����ӷ��ء�
		 */
		Connection conn = tl.get();//��ȡ��ǰ�̵߳���������
		if(conn!=null)
			return conn;
		return DriverManager.getConnection(url,name,password);
	}
	
	//�ͷ�����
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
		//����������򲻹ر����ݿ����ӣ���������ύ��ع��йرգ�
		Connection transConn = tl.get();//������
		if(transConn==conn){//Ҫ�رյ������������
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
	 * ��������
	 * ʹ���������ڿ������񷽷��л�ȡ���ݿ�����ӣ��ҹ涨ֻ��������ǰ�л�ȡ���ݿ�����
	 * �����ط���ȡ��Ϊ����
	 */
	public static void beginTransaction() throws SQLException{
		//��ȡtl�е����ݿ�����
		Connection conn = tl.get();
		//���tl���Ѿ��������ݿ����ӣ���˵���Ѿ�����������
		if(conn!=null)
			throw new SQLException("�Ѿ����������������ظ�������");
		conn = getConnection();//��ȡ���ݿ�����
		conn.setAutoCommit(false);//����Ϊ�ֶ��ύ
		tl.set(conn);//����ȡ�����ݿ����ӷ���tl�У���ʱ�������Ѿ������ݿ�����
	}
	
	/*
	 * �ύ����
	 * �ύ�����񣬹ر����ݿ����ӣ��ҽ��������ύ�ͻع��йر����ݿ�����
	 * ���������ط����йر�
	 */
	public static void commitTransaction() throws SQLException{
		Connection conn = tl.get();//��ȡ��ǰ�߳�����������ݿ�����
		if(conn == null)
			throw new SQLException("û�����񣬲����ύ��");
		conn.commit();//�ύ����
		conn.close();//�ر����ݿ�����
		conn = null;
		tl.remove();//��tl�е����ݿ������Ƴ�
	}
	
	/*
	 * �ع�����
	 * ��������쳣����Ҫ�ع����ع��꣬�ر����ݿ�����
	 */
	public static void rollbackTransaction() throws SQLException{
		//��ȡ��ǰ�߳��е����ݿ�����
		Connection conn = tl.get();
		//�жϸ������Ƿ����
		if(conn == null)
			throw new SQLException("���ݿ����Ӳ����ڣ����ܽ��лع���");
		conn.rollback();//����ع�
		conn.close();//�ر����ݿ�����
		conn = null;
		tl.remove();//��tl�е����ݿ������Ƴ�
	}
	
	//������ɾ�Ĳ���
	public static int update(String sql,Object... params) {
		Connection conn = null;
		PreparedStatement pre = null;
		
		try {
			/*
			 * ��ȡ���ݿ�����
			 * 1.������������ڵ���update����֮ǰ���Ѿ������������������Ѿ���������
			 * �����ȡ�����Ӿ��������е����ӣ��������µ�����
			 * 2.�������������������Ӿͻ�����һ���µ�����
			 */
			conn = getConnection();
			//��ȡPreparedStatment����
			pre = conn.prepareStatement(sql);
			fillStatement(pre, params);
			return pre.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}finally{
			release(conn,pre,null);
		}
	}
	
	//��Ӳ�������Ҫ��������������
	public static Object  insert(String sql,Object... params) {
			Connection conn = null;
			PreparedStatement pre = null;
			ResultSet rs =  null;
			try {
				//��ȡ���ݿ�����
				conn = getConnection();
				//��ȡPreparedStatment����
				pre = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				//����sql����ֵ
				fillStatement(pre, params);
				//ִ��sql���
				pre.executeUpdate();
				//��ȡ����
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
			//��ȡ���ݿ�����
			conn = getConnection();
			//��ȡPreparedStatment����
			pre = conn.prepareStatement(sql);
			fillStatement(pre, params);
			//ִ��sql���
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
		//��ȡ��ṹ
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
	
	//������insert����
	public static  List insertbatch(String sql, Object [][]params){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			pre = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			//���ò���
			if(params!=null){
				for(int i=0;i<params.length;i++){
					fillStatement(pre, params[i]);
						pre.addBatch();//��ӵ���������������
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
	
	//������update��delete����
	//������insert����
		public static int[] udpatebatch(String sql, Object [][]params){
			Connection conn = null;
			PreparedStatement pre = null;
			try {
				conn = JdbcUtils.getConnection();
				pre = conn.prepareStatement(sql);
				//���ò���
				if(params!=null){
					for(int i=0;i<params.length;i++){
						fillStatement(pre, params[i]);
							pre.addBatch();//��ӵ���������������
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
