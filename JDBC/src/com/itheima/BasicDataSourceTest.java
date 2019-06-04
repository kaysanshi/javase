package com.itheima;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

/*
 * 测试，配置好的数据源对象
 * BasicDataSource
 * 使用Demo_01BasicDataSource类中，配置好的对象source
 * 使用连接池是要用这样各类:
 * QueryRunner(DataSource ds)执行 源是datasource的接口;
 */
public class BasicDataSourceTest {
	public static void main(String[] args) throws SQLException {
		//创建QueryRunner对象，构造方法中，传递BasicDataSource类对象
		//获得连接驱动;
		BasicDataSource source = BasicDataSourceDBCP.getSource();
		//执行;时都已经通过连接池获得了对象;
		QueryRunner qr = new QueryRunner(source);
		//直接传入sql语句;
		List<Object[]> list = qr.query("SELECT * FROM GJP_LEDGER", new ArrayListHandler());
		for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.print(object); 
			}
			System.out.println();
		}
		//下面的是用jdbcutils的使用;
		System.out.println("=====================");
		DataSource dataSource = JDBCUtils.getDataSource();
		QueryRunner qr2 = new QueryRunner(dataSource);
		List<Object[]> list2 = qr2.query("SELECT * FROM GJP_LEDGER", new ArrayListHandler());
		for (Object[] objects : list2) {
			for (Object object : objects) {
				System.out.print(object);
			}
			System.out.println();
		}
	}
}
