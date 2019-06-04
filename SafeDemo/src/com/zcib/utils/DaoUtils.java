package com.zcib.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * 获取数据源
 * @author 555
 *
 */
public class DaoUtils {
	//c3p0
	private static DataSource source=new ComboPooledDataSource();
	private DaoUtils(){
		
	}
	//数据源
	public static DataSource getSource(){
		return source;
	}
	//获取连接
	public static Connection getConnection(){
		try {
			return source.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		
	}
}
