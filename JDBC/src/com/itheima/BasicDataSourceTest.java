package com.itheima;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

/*
 * ���ԣ����úõ�����Դ����
 * BasicDataSource
 * ʹ��Demo_01BasicDataSource���У����úõĶ���source
 * ʹ�����ӳ���Ҫ����������:
 * QueryRunner(DataSource ds)ִ�� Դ��datasource�Ľӿ�;
 */
public class BasicDataSourceTest {
	public static void main(String[] args) throws SQLException {
		//����QueryRunner���󣬹��췽���У�����BasicDataSource�����
		//�����������;
		BasicDataSource source = BasicDataSourceDBCP.getSource();
		//ִ��;ʱ���Ѿ�ͨ�����ӳػ���˶���;
		QueryRunner qr = new QueryRunner(source);
		//ֱ�Ӵ���sql���;
		List<Object[]> list = qr.query("SELECT * FROM GJP_LEDGER", new ArrayListHandler());
		for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.print(object); 
			}
			System.out.println();
		}
		//���������jdbcutils��ʹ��;
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
