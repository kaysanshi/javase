package com.itheima.dbutils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.itheima.domain.Account;
import com.mchange.v2.c3p0.ComboPooledDataSource;
//这是用dbutils框架的形式来写的并不是一个通用的类
public class DbUtils {
	/**
	 * DbUtils方式实现查询
	 * @throws SQLException 
	 */
	public void query() throws SQLException{
		//需要传一个数据元进去
		QueryRunner runner = new QueryRunner(new ComboPooledDataSource());
		List<Account>list = runner.query("select * from account where money>?"
			, new ResultSetHandler<List<Account>>(){
				public List<Account> handle(ResultSet rs) throws SQLException {
					List<Account> list = new ArrayList<Account>();
					while(rs.next()){
						Account acc = new Account();
						acc.setId(rs.getInt("id"));
						acc.setName(rs.getString("name"));
						acc.setMoney(rs.getDouble("money"));
						list.add(acc);
					}
					return list;
				}
		}, 500);
	}
	/**
	 * DBUtils方式实现增删改
	 * @throws SQLException 
	 */
	public void update() throws SQLException{
		QueryRunner runner = new QueryRunner(new ComboPooledDataSource());
		runner.update("update account set money=? where name=?", 888,"a");
	}
}
