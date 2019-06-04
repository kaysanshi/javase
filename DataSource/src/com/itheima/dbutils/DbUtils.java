package com.itheima.dbutils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.itheima.domain.Account;
import com.mchange.v2.c3p0.ComboPooledDataSource;
//������dbutils��ܵ���ʽ��д�Ĳ�����һ��ͨ�õ���
public class DbUtils {
	/**
	 * DbUtils��ʽʵ�ֲ�ѯ
	 * @throws SQLException 
	 */
	public void query() throws SQLException{
		//��Ҫ��һ������Ԫ��ȥ
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
	 * DBUtils��ʽʵ����ɾ��
	 * @throws SQLException 
	 */
	public void update() throws SQLException{
		QueryRunner runner = new QueryRunner(new ComboPooledDataSource());
		runner.update("update account set money=? where name=?", 888,"a");
	}
}
