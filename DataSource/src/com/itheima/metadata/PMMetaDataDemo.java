package com.itheima.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
//��ȡ����Դ���ݣ�
//ͨ��c3p0������config��Ϣ��Ȼ����ComboPooledDataSource source = new ComboPooledDataSource();
//����ȡ����
public class PMMetaDataDemo {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ComboPooledDataSource source = new ComboPooledDataSource();
		try{
			conn = source.getConnection();
			ps = conn.prepareStatement("select * from account where name=? and money=?");
			//--��ȡ����Ԫ����
			ParameterMetaData metaData = ps.getParameterMetaData();
			//----�����ĸ���
			int count = metaData.getParameterCount();
			System.out.println(count);
			//----��ȡ����������
			String type = metaData.getParameterTypeName(1);
			System.out.println(type);
			String type2 = metaData.getParameterTypeName(2);
			System.out.println(type2);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtils.closeQuietly(conn, ps, rs);
		}
	}
}
