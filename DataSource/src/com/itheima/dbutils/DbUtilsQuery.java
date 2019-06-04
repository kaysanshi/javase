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
//�����ݷ�װ��handler��
public class DbUtilsQuery {
	/**
	 * Mydb��ʽʵ�ֲ�ѯ
	 * @throws SQLException 
	 *
	 *	�ص�����:������a���÷���b,������b��ִ�еĹ�����,���е�һЩ�߼���Ҫ�ɷ���a����֪,��ʱ��Ҫ����a�ڵ��÷���bʱ���߼�����,��java���ǲ�������javaԴ����,��ʱ����ʹ�ûص����������
	 *			��ν�Ļص�,���Ƿ���a�ͷ���bԼ��һ���ӿ�,������ӿ��ж���һ������,�������������ͨ������hander����,a�����ڵ���bʱ,����˽ӿڵ�һ��ʵ��,��������handler����,���߼�����,����b��ִ�еĹ�������Ҫִ��a������߼�ʱ,���ýӿ�ʵ�ֵ�handler��������,��ʱa����bʱ,b�������õ�a������߼�,����������̽����ص�.
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
	 * DbUtils��ʽʵ�ֲ�ѯ
	 * @throws SQLException 
	 */
	public void find2() throws SQLException{
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
		System.out.println(list);
	}
	
	/**
	 * ���Ϸ�ʽʵ�ֵĲ�ѯ
	 *  ---sql/sql�еĲ���/������Ĵ���
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
