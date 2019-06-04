package com.itheima.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
//获取参数源数据；
//通过c3p0的配置config信息，然后用ComboPooledDataSource source = new ComboPooledDataSource();
//来获取连接
public class PMMetaDataDemo {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ComboPooledDataSource source = new ComboPooledDataSource();
		try{
			conn = source.getConnection();
			ps = conn.prepareStatement("select * from account where name=? and money=?");
			//--获取参数元数据
			ParameterMetaData metaData = ps.getParameterMetaData();
			//----参数的个数
			int count = metaData.getParameterCount();
			System.out.println(count);
			//----获取参数的类型
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
