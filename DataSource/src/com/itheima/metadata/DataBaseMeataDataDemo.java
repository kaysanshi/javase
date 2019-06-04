package com.itheima.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
//����Դc3p0���ӣ�Ԫ���ݵ�ʹ��
public class DataBaseMeataDataDemo {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//�洢����Դ�ӿڳء�
		ComboPooledDataSource source = new ComboPooledDataSource();
		try{
			conn = source.getConnection();
			//--��ȡ��ǰ���ݿ��Ԫ����
			DatabaseMetaData metaData = conn.getMetaData();
			//----��ȡ���ݿ�����ʱʹ�õ�URL
			String url = metaData.getURL();
			System.out.println(url);
			//----��ȡ���ݿ���û���
			String username = metaData.getUserName();
			System.out.println(username);
			//----��ȡ����������
			String driverName = metaData.getDriverName();
			System.out.println(driverName);
			//----��ȡ���ݿ���ָ�����������Ϣ
			rs = metaData.getPrimaryKeys(null, null, "account");
			while(rs.next()){
				short cseq = rs.getShort("KEY_SEQ");
				String cname = rs.getString("COLUMN_NAME");
				System.out.println(cseq+":"+cname);
			}
			//----��ȡ��
			rs = metaData.getTables(null, null, "%", new String[]{"TABLE"});
			while(rs.next()){
				String tabName = rs.getString("TABLE_NAME");
				System.out.println(tabName);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtils.closeQuietly(conn, ps, rs);
		}
	}
}
