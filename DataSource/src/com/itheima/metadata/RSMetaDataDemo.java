package com.itheima.metadata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
//�����Ԫ����
public class RSMetaDataDemo {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ComboPooledDataSource source = new ComboPooledDataSource();
		try{
			conn = source.getConnection();
			ps = conn.prepareStatement("select * from account");
			rs = ps.executeQuery();
			//--��ȡ�����Ԫ����
			ResultSetMetaData metaData = rs.getMetaData();
			//----��ȡ������е�����
			int cc = metaData.getColumnCount();
			//System.out.println(cc);
			//----��ȡ�������ָ���е�����
			//String cn = metaData.getColumnName(2);
			//System.out.println(cn);
			//----��ȡ�������ָ���е����͵�����
			//String ct = metaData.getColumnTypeName(3);
			//System.out.println(ct);
			
			System.out.println("-------------------------------------------------------");
			for(int i = 1;i<=cc;i++){
				String cn = metaData.getColumnName(i);
				String ct = metaData.getColumnTypeName(i);
				System.out.print(cn+":"+ct+"\t\t");
			}
			System.out.println();
			System.out.println("-------------------------------------------------------");
			while(rs.next()){
				for(int i =1 ;i<=cc;i++){
					Object obj = rs.getObject(i);
					System.out.print(obj+"\t\t\t");
				}
				System.out.println();
			}
			
			System.out.println("-------------------------------------------------------");
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�õ��˿�ܵ�Dbutils
			DbUtils.closeQuietly(conn, ps, rs);
		}
	}
}
