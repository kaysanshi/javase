package com.hanshunping4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlHelper {
	//�������ݿ��֪ʶ
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;//������һ����ʱ��������ʱ�洢���ݿ��ѯ�Ľ������
		//�ر����ݿ�ķ���;
		public void close(){
			try {
				if(rs!=null){
				rs.close();
				}
				if(pst!=null){
					pst.close();
				}
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		//��ѯ���ݿ����
		public ResultSet queryExectue(String sql,String[] paras){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/student?user=root&password=123";
				conn=DriverManager.getConnection(url);
				
				pst=conn.prepareStatement(sql);
				//������?��ֵ��
				for(int i=0;i<paras.length;i++){
					pst.setString(i+1, paras[i]);
				}
				rs=pst.executeQuery();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					//��ʱ��Ҫ�ر�;
					//this.close();
				}
			return rs;
			
		}
		/*//��ѯ���ݿ������ʱ��Ϊ�˳�ʼ������д�Ĵ���,
		public ResultSet queryExectue(String sql){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/Student?user=root&password=123";
				conn=DriverManager.getConnection(url);
				
				pst=conn.prepareStatement(sql);
				
				rs=pst.executeQuery();
				
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					//��ʱ��Ҫ�ر�;
					//this.close();
				}
			return rs;
			
		}
	*/
		//��ɾ��
		public boolean updExcetion(String sql,String[] paras){
			boolean b=true;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/student?user=root&password=123";
			conn=DriverManager.getConnection(url);
			
			pst=conn.prepareStatement(sql);
			//������?��ֵ��
			for(int i=0;i<paras.length;i++){
				pst.setString(i+1, paras[i]);
			}
			//ִ��Sql���
			if(pst.executeUpdate()!=1){
				b=false;
				}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{
				this.close();
			}
		return false;
		}
}
