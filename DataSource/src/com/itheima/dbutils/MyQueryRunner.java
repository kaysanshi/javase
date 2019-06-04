package com.itheima.dbutils;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.DbUtils;
///�Լ�����һ������Դ
public class MyQueryRunner {
	private DataSource source = null;
	public MyQueryRunner() {
	}
	public MyQueryRunner(DataSource source) {
		this.source = source;
	}
	//��ɾ�ģ�
	public int update(String sql, Object... params) throws SQLException{
		Connection conn = source.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		//--��ȡ����Ԫ����,��ȡ�����ĸ���
		ParameterMetaData metaData = ps.getParameterMetaData();
		int count = metaData.getParameterCount();
		//--ѭ�����ò�����ֵ
		for(int i=1;i<=count;i++){
			ps.setObject(i, params[i-1]);
		}
		//--ִ��update����
		int num = ps.executeUpdate();
		DbUtils.closeQuietly(conn, ps, null);
		return num;
	}
	//��ѯ
	public <T> T query(String sql, MyResultSetHandler<T> rsh, Object... params)throws SQLException{
		Connection conn = source.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		//--��ȡ����Ԫ����,��֪��������
		ParameterMetaData metaData = ps.getParameterMetaData();
		int count = metaData.getParameterCount();
		//--ѭ�����ò���
		for(int i=1;i<=count;i++){
			ps.setObject(i, params[i-1]);
		}
		
		//--ִ�в�ѯ��ȡ�����
		ResultSet rs = ps.executeQuery();
		
		//--�ص�������������߼�
		T t = rsh.handle(rs);
		DbUtils.closeQuietly(conn, ps, rs);
		return t;
	}

}