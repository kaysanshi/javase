package com.itheima.dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;


import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DbUtilsUpdate {
	
	public void del() throws SQLException{
		MyQueryRunner runner = new MyQueryRunner(new ComboPooledDataSource());
		runner.update("delete from account where id=?",3);
	}

	public void add() throws SQLException{
		MyQueryRunner runner = new MyQueryRunner(new ComboPooledDataSource());
		runner.update("insert into account values(null,?,?)","c",1000);
	}
	/**
	 * MyDBUtils方式实现增删改
	 * @throws SQLException 
	 */
	
	public void add3() throws SQLException{
		MyQueryRunner runner = new MyQueryRunner(new ComboPooledDataSource());
		runner.update("update account set money=? where name=?", 777,"a");
	}
	/**
	 * DBUtils方式实现增删改
	 * @throws SQLException 
	 */

	public void add2() throws SQLException{
		QueryRunner runner = new QueryRunner(new ComboPooledDataSource());
		runner.update("update account set money=? where name=?", 888,"a");
	}
	/**
	 * 古老方法实现增删改功能
	 * 	--在进行增删改操作时,每次都不一样的只有sql语句和sql语句中的参数
	 */

	public void update1(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//先获取数据源
		ComboPooledDataSource source = new ComboPooledDataSource();
		try{
			conn = source.getConnection();
			ps = conn.prepareStatement("update account set money=? where name=?");
			ps.setDouble(1, 999);
			ps.setString(2, "a");
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtils.closeQuietly(conn, ps, rs);
		}
		
	}
}
