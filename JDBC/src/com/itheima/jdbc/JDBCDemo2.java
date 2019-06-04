package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.itheima.util.JDBCUtils;

public class JDBCDemo2 {
	
	public void delete(){
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			stat =  conn.createStatement();
			stat.executeUpdate("delete from user where name='zhaoliu'");
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, stat, conn);
		}
	}
	

	public void find(){
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			stat =  conn.createStatement();
			rs = stat.executeQuery("select * from user where name='zhaoliu'");
			while(rs.next()){
				String name = rs.getString("name");
				String password = rs.getString("password");
				System.out.println(name+":"+password);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, stat, conn);
		}
	}
	

	public void update() {
		Connection conn = null;
		Statement stat = null;
		try{
			conn = JDBCUtils.getConn();
			stat =  conn.createStatement();
			stat.executeUpdate("update user set password=999 where name='zhaoliu'");
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(null, stat, conn);
		}
	}
	

	public void add() {
		Connection conn = null;
		Statement stat = null;
		try {
			// 1.ע�����ݿ�����
			// 2.��ȡ����
			conn = JDBCUtils.getConn();
			// 3.��ȡ����������
			stat = conn.createStatement();
			// 4.ִ��sql���
			int count = stat
					.executeUpdate("insert into user values (null,'zhaoliu','123456','zhaoliu@qq.com','1999-09-09')");
			// 5.������
			if (count > 0) {
				System.out.println("ִ�гɹ�!Ӱ�쵽������Ϊ" + count);
			} else {
				System.out.println("ִ��ʧ��!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//6.�ر���Դ
			JDBCUtils.close(null, stat, conn);
		}
	}
}
