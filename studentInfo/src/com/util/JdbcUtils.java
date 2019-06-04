package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//�����������ݿ����
public class JdbcUtils {
	//������Ҫ�Ķ���
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/students";
	String user="root";
	String passwd="123";
	int sum=0;
	//���캯������ʼ��
	public JdbcUtils(){
		try {
			//��������
			Class.forName(driver);
			//�õ�����
			con=DriverManager.getConnection(url,user,passwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//��ѯ��ȡ�����[]params��ͨ��?��ֵ��ʽ���Է�ֹ©��ע�뷽ʽ����֤��ȫ��
	public ResultSet queryExecute(String sql,String []params){
		try {
			ps=con.prepareStatement(sql);
			//��sql�Ĳ�����ֵ
			for(int i=0;i<params.length;i++){
				ps.setString(i+1, params[i]);
			}
			//ִ�в�ѯ
			rs=ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			throw new RuntimeException(e.getMessage(),e);
		}
		//���ؽ����
		return rs;
	}
	/*
	 * ��һ��ResultSet����ת��Ϊһ��List<Map<String,Object>>����
	 */
	public static List<Map<String,Object>> RSToList(ResultSet rs) throws SQLException{
		List<Map<String,Object>>  list = new ArrayList<Map<String,Object>>();
		ResultSetMetaData rsmd = rs.getMetaData();//��ȡ��ṹ
		//����������¼
		while(rs.next()){
			//����һ��Map����
			Map<String,Object> map = new HashMap<String,Object>();
			for(int i=1;i<=rsmd.getColumnCount();i++){
				//����ֶ�����rsmd.getColumnName(i)��Ϊkey����Ӧ��ֵΪvalue
				map.put(rsmd.getColumnName(i).toLowerCase(),rs.getObject(i));
			}
			list.add(map);//����һ����¼��ӵ�list��
		}
		return list;
	}
	//��ȡ�����Ľ���ĸ���
	public int queryExecute(String sql){
		try {
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			if(rs.next()){
				sum=rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		//���ؽ����
		return sum;
	}
	//����ɾ���޸Ĳ���
	public boolean savegrade(String sql,String []params){
		boolean b=true;
		try {
			ps=con.prepareStatement(sql);
			//��sql�Ĳ�����ֵ
			for(int i=1;i<params.length;i++){
				ps.setString(i, params[i]);
			}
			//ִ�в�ѯ
			if(ps.executeUpdate()!=1){
				b=false;
			}
		} catch (Exception e) {
			b=false;
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			this.close();
		}
		//���ؽ����
		return b;
		
	}
	//�ر���Դ�ķ���
	public void close(){
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}

