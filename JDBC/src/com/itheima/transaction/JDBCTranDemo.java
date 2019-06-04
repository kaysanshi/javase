package com.itheima.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import com.itheima.util.JDBCUtils;
//����Ĺ���
public class JDBCTranDemo {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//���ûع��㣻
		Savepoint sp = null;
		try{
			conn = JDBCUtils.getConn();
			//��������===start transaction
			conn.setAutoCommit(false);
			
			ps = conn.prepareStatement("update account set money=money-100 where name = ?");
			ps.setString(1, "a");
			ps.executeUpdate();

			ps = conn.prepareStatement("update account set money=money+100 where name=?");
			ps.setString(1, "b");
			ps.executeUpdate();
			
			//���ûع���
			sp = conn.setSavepoint();
			
			ps = conn.prepareStatement("update account set money=money-100 where name = ?");
			ps.setString(1, "a");
			ps.executeUpdate();
			
			//String str = null;
			//str.toUpperCase();
			
			ps = conn.prepareStatement("update account set money=money+100 where name=?");
			ps.setString(1, "b");
			//ִ�и���
			ps.executeUpdate();
			//�����ύ
			conn.commit();
		}catch (Exception e) {
			try {
				if(sp == null){//����ع���Ϊnull˵��û��ִ�е����ûع������ʱ�������쳣,Ӧ�����������лع�
					//����ع�
					conn.rollback();	
				}else{//˵��sp��Ϊnull,���Ի�����ع���,����ִ����������,����Ҫע��,���ϣ��֮ǰ�����������,��Ȼ��Ҫ���ύ����
				//�ع����ύ
					conn.rollback(sp);
					conn.commit();
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
	}
}
