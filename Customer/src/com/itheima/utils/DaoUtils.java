package com.itheima.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DaoUtils {
	private static DataSource source=new ComboPooledDataSource();
	private DaoUtils(){
		
	}
	public static DataSource getSource(){
		return source;
	}
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
