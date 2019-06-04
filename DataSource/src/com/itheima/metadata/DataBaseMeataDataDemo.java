package com.itheima.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
//数据源c3p0连接；元数据的使用
public class DataBaseMeataDataDemo {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//存储数据源接口池。
		ComboPooledDataSource source = new ComboPooledDataSource();
		try{
			conn = source.getConnection();
			//--获取当前数据库的元数据
			DatabaseMetaData metaData = conn.getMetaData();
			//----获取数据库连接时使用的URL
			String url = metaData.getURL();
			System.out.println(url);
			//----获取数据库的用户名
			String username = metaData.getUserName();
			System.out.println(username);
			//----获取驱动的名称
			String driverName = metaData.getDriverName();
			System.out.println(driverName);
			//----获取数据库中指定表的主键信息
			rs = metaData.getPrimaryKeys(null, null, "account");
			while(rs.next()){
				short cseq = rs.getShort("KEY_SEQ");
				String cname = rs.getString("COLUMN_NAME");
				System.out.println(cseq+":"+cname);
			}
			//----获取表
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
