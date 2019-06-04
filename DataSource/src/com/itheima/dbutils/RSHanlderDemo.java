package com.itheima.dbutils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;


import com.itheima.domain.Account;
import com.mchange.v2.c3p0.ComboPooledDataSource;
//
public class RSHanlderDemo {
	//ScalarHandler:��ȡ������е�һ������ָ���е�ֵ,���������е�ֵ��ѯ

	public void tes9() throws SQLException{
		QueryRunner runner = new QueryRunner(new ComboPooledDataSource());
		Long count = (Long)runner.query("select count(*) from account",new ScalarHandler());
		System.out.println(count);
	}
	
	//KeyedHandler(name)����������е�ÿһ�����ݶ���װ��һ��Map��(List<Map>)���ٰ���Щmap�ٴ浽һ��map���keyΪָ�����С�
	
	public void tes8() throws SQLException{
		QueryRunner runner = new QueryRunner(new ComboPooledDataSource());
		 Map<Object, Map<String, Object>> map = runner.query("select * from account where money>?", new KeyedHandler("id"),500);
		System.out.println(map);
	}
	//ColumnListHandler�����������ĳһ�е����ݴ�ŵ�List�С�

	public void tes7() throws SQLException{
		QueryRunner runner = new QueryRunner(new ComboPooledDataSource());
		List<Object>list = runner.query("select * from account where money>?", new ColumnListHandler(3),500);
		System.out.println(list);
	}
	//MapListHandler����������е�ÿһ�����ݶ���װ��һ��Map�Ȼ���ٴ�ŵ�List

	public void tes6() throws SQLException{
		QueryRunner runner = new QueryRunner(new ComboPooledDataSource());
		List<Map<String, Object>> list = runner.query("select * from account where money>?", new MapListHandler(),500);
		System.out.println(list);
	}
	
	//MapHandler����������еĵ�һ�����ݷ�װ��һ��Map�key��������value���Ƕ�Ӧ��ֵ��

	public void tes5() throws SQLException{
		QueryRunner runner = new QueryRunner(new ComboPooledDataSource());
		 Map<String, Object> map = runner.query("select * from account where money>?", new MapHandler(),500);
		System.out.println(map);
	}
	
	//BeanListHandler����������е�ÿһ�����ݶ���װ��һ����Ӧ��JavaBeanʵ���У���ŵ�List�

	public void tes4() throws SQLException{
		QueryRunner runner = new QueryRunner(new ComboPooledDataSource());
		List<Account>list = runner.query("select * from account where money>?", new BeanListHandler<Account>(Account.class),500);
		System.out.println(list);
	}
	
	//BeanHandler����������еĵ�һ�����ݷ�װ��һ����Ӧ��JavaBeanʵ���С�

	public void tes3() throws SQLException{
		QueryRunner runner = new QueryRunner(new ComboPooledDataSource());
		Account acc = runner.query("select * from account where money>?", new BeanHandler<Account>(Account.class),500);
		System.out.println(acc);
	}
	//ArrayListHandler���ѽ�����е�ÿһ�����ݶ�ת��һ���������飬�ٴ�ŵ�List�С�

	public void tes2() throws SQLException{
		QueryRunner runner = new QueryRunner(new ComboPooledDataSource());
		List<Object[]> list = runner.query("select * from account where money>?", new ArrayListHandler(),500);
		System.out.println(list);
	}
	
	//ArrayHandler:�ѽ�����еĵ�һ������ת�ɶ������顣Ȼ����з���

	public void test1() throws SQLException{
		QueryRunner runner = new QueryRunner(new ComboPooledDataSource());
		Object[] objs = runner.query("select * from account where money>?", new ArrayHandler(),500);
		System.out.println(objs);
	}
}
