package com.mhl.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//���������е�����ģ�������������ݿ�ģ��,
//���ݿ�ģ��ר�������������ݿ����
public class SqlHelper {
	//������Ҫ�Ķ���
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int sum=0;//��¼����;
		//��ʼ������;
	public SqlHelper(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/Restaurant?";
			String user="root";
			String passwd="123";
			
			//�õ�����
			con=DriverManager.getConnection(url,user,passwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	///���в�ѯ�Ĳ���;������һ�������rs;
	//[]params��ͨ��?��ֵ��ʽ���Է�ֹ©��ע�뷽ʽ����֤��ȫ��
		public ResultSet queryExecute(String sql,String []params){
			try {
				ps=con.prepareStatement(sql);
				//��sql�Ĳ�����ֵ
				for(int i=0;i<params.length;i++)
				{
					ps.setString(i+1, params[i]);
				}
				//ִ�в�ѯ
				rs=ps.executeQuery();
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			//���ؽ����
			return rs;
		}
		//��ѯ����ʵ�����������½���ʾ�Ĳ�����¼
		public int queryExecute(String sql)
		{
			try {
				ps=con.prepareStatement(sql);
				//����һ�������
				rs=ps.executeQuery();
				if(rs.next())
				{
					sum=rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			//���ؽ����
			return sum;
		}
		//������ɾ�ĵĲ���
		public boolean updateExecete(String sql,String []params)
		{
			boolean b=true;
			try {
				ps=con.prepareStatement(sql);
				//��sql�Ĳ�����ֵ
				for(int i=0;i<params.length;i++)
				{
					ps.setString(i+1, params[i]);
				}
				//ִ�в�ѯ�������κν����ʱʹ��������
				if(ps.executeUpdate()!=1)
				{
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
		public void close()
		{
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
