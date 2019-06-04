package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JDBCDemo1 {
	public static void main(String[] args){
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try{
			//1.ע�����ݿ�����
			//--����mysql��Driver���ʵ�����Լ�ע����һ��,��������ע����һ��,���ǻᵼ��MySql������ע������
			//--����MySql��Driver����ʱ,�����˳���;����Mysql������������һ��,���л����ݿ�ʱ��Ҫ�Ķ�java����
			//DriverManager.registerDriver(new Driver());
			Class.forName("com.mysql.jdbc.Driver");
			//2.��ȡ���ݿ�����
			conn = DriverManager.getConnection("jdbc:mysql:///blob?user=root&password=123");
			//3.��ȡ����������
			stat = conn.createStatement();
			//4.���ô���������sql��䵽���ݿ���ִ��,��ȡ���������
			rs = stat.executeQuery("select * from account");
			//5.�����������ȡ��ѯ���
			while(rs.next()){
				String name = rs.getString("name");
				System.out.println(name);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			//6.�ر���Դ
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
}
