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
	Statement方式执行批处理:
		优点:可以执行多条不同结构的sql语句
		缺点:没有使用预编译机制,效率低下,如果要执行多条结构相同仅仅参数不同的sql时,仍然需要写多次sql语句的主干
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
