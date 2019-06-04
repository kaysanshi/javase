package com.itheima.batch;

import java.sql.Connection;
import java.sql.Statement;

import com.itheima.util.JDBCUtils;

/*
	create database day10batch;
	use day10batch;
	create table batchDemo(
		id int primary key auto_increment,
		name varchar(20)
	);
	insert into batchDemo values(null,'aaaa');
	insert into batchDemo values(null,'bbb');
	insert into batchDemo values(null,'cc');
	insert into batchDemo values(null,'d');
 */
/*
	Statement��ʽִ��������:
		�ŵ�:����ִ�ж�����ͬ�ṹ��sql���
		ȱ��:û��ʹ��Ԥ�������,Ч�ʵ���,���Ҫִ�ж����ṹ��ͬ����������ͬ��sqlʱ,��Ȼ��Ҫд���sql��������
 */
public class StatementBatch {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stat = null;
		try{
			conn = JDBCUtils.getConn();
			stat = conn.createStatement();
			stat.addBatch("create database day10batch");
			stat.addBatch("use day10batch");
			stat.addBatch("create table batchDemo("+
								"id int primary key auto_increment,"+
								"name varchar(20)"+
							")");
			stat.addBatch("insert into batchDemo values(null,'aaaa')");
			stat.addBatch("insert into batchDemo values(null,'bbb')");
			stat.addBatch("insert into batchDemo values(null,'cc')");
			stat.addBatch("insert into batchDemo values(null,'d')");
			
			stat.executeBatch();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(null, stat, conn);
		}
	}
}
