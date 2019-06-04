package com.itheima.dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.itheima.domain.Account;
import com.mchange.v2.c3p0.ComboPooledDataSource;
//把数据封装到handler中
public class DbUtilsQuery {
	/**
	 * Mydb方式实现查询
	 * @throws SQLException 
	 *
	 *	回调函数:当方法a调用方法b,而方法b在执行的过程中,其中的一些逻辑需要由方法a来告知,此时需要方法a在调用方法b时将逻辑传入,而java中是不允许传递java源代码,此时可以使用回调机制来解决
	 *			所谓的回调,就是方法a和方法b约定一个接口,在这个接口中定义一个方法,这个方法的名字通常叫做hander方法,a方法在调用b时,传入此接口的一个实现,其中利用handler方法,将逻辑传入,方法b在执行的过程中需要执行a传入的逻辑时,调用接口实现的handler方法即可,此时a调用b时,b回来调用的a传入的逻辑,所以这个过程叫做回调.
	 */

	public void find3() throws SQLException{
		MyQueryRunner runner = new MyQueryRunner(new ComboPooledDataSource());
		List<Account> list = runner.query("select * from account where money>?"
				, new MyResultSetHandler<List<Account>>(){

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
		System.out.println(list);
	}
	
	/**
	 * DbUtils方式实现查询
	 * @throws SQLException 
	 */
	public void find2() throws SQLException{
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
		System.out.println(list);
	}
	
	/**
	 * 古老方式实现的查询
	 *  ---sql/sql中的参数/结果集的处理
	 */
	public void find1(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ComboPooledDataSource source  = new ComboPooledDataSource(); 
		List<Account> list = new ArrayList<Account>();
		try{
			conn = source.getConnection();
			ps = conn.prepareStatement("select * from account where money>?");
			ps.setDouble(1, 500);
			rs = ps.executeQuery();
			while(rs.next()){
				Account acc = new Account();
				acc.setId(rs.getInt("id"));
				acc.setName(rs.getString("name"));
				acc.setMoney(rs.getDouble("money"));
				list.add(acc);
			}
			
			System.out.println(list);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtils.closeQuietly(conn, ps, rs);
		}
	}
	
}
