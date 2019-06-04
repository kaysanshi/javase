package com.itheima;

import org.apache.commons.dbcp.BasicDataSource;

/*
 * 使用数据库的连接池
 * DBCP连接池1.8就不用了;
 *   BasicDataSource 实现 javax.sql.DataSource接口
 *   dbcp:应用两个jar包:commons-dbcp.jar:连接的实现
 *   commons-pool.jar包:commons-pool.jar:连接池实现的库;
 *   使用:1.导入jar包;创建对象,设置属相;
 *   
 */
public class BasicDataSourceDBCP {

	public static BasicDataSource getSource(){
		//基础的数据源
		BasicDataSource source = new BasicDataSource();
		//用BasicDataSource方法，设置必要参数
		//设置驱动程序
		source.setDriverClassName("com.mysql.jdbc.Driver");
		//设置数据库连接URL
		source.setUrl("jdbc:mysql://localhost:3306/gjp");
		//设置用户名和密码
		source.setUsername("root");
		source.setPassword("123");
		return source;
	}
}
