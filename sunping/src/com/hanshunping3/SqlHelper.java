package com.hanshunping3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//дһ��������ר�Ŷ����ݿ�Ĳ���
//����model���б������� ���г�ʼ��;
public class SqlHelper {
	
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	//��Щ�ŵ����캯���Ǻý��г�ʼ��
	public SqlHelper(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/Student";
			String user="root";
			String password="123";
			//�õ�����
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//����Ĳ�����������ѯ
	public ResultSet queryExcetion(String sql,String[]paras){
		try {
			ps=conn.prepareStatement(sql);
			//�Բ�����ֵ
			for(int i=0;i<paras.length;i++){
				ps.setString(i+1, paras[i]);
			}
			//ִ�в�ѯ
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//��ʱ���ܹر���Ϊ�ڲ�ѯ��model�㻹Ҫ����һ�������
			//this.close();
		}
		//���ؽ����
		return rs;
	}
	//������ɾ��
	public boolean upExcetion(String sql,String[]paras){
		boolean b=false;
		try {
			ps=conn.prepareStatement(sql);
			for(int i=0;i<paras.length;i++){
				ps.setString(i+1, paras[i]);
			}
			if(ps.executeUpdate()!=1){
				b=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return false;
		
	}
	public void close(){
		
		try {
			if(rs!=null){
				rs.close();
				}
			if(ps!=null){
				ps.close();
			}
			if(conn!=null){
				conn.close();
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
