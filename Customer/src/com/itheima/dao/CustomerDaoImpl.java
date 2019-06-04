package com.itheima.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itheima.domain.Customer;
import com.itheima.utils.DaoUtils;

public class CustomerDaoImpl implements CustomerDao{
	/**
	 * 根据用户名查找用户；
	 * @param name
	 * @return
	 */
	@Override
	public Customer finduserByName(String name) {
		// TODO Auto-generated method stub
		String sql="select * from customer where name=?";
		try {
			QueryRunner runner=new QueryRunner(DaoUtils.getSource());

			return runner.query(sql, new BeanHandler<Customer>(Customer.class),name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	/**
	 * 增加用户
	 * @param customer
	 */
	@Override
	public void addCustomer(Customer customer){
		String sql="insert into customer values(null,?,?,?,?,?,?,?,?)";
		try {
			QueryRunner runner=new QueryRunner(DaoUtils.getSource());
			runner.update(sql,customer.getName(),customer.getGender(),customer.getBirthday(),customer.getCellphone(),customer.getEmail(),customer.getPreference(),customer.getType(),customer.getDescription());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	/**
	 * 获取客户列表；
	 * @return 封装了所有客户信息的集合如果没有返回为空
	 */
	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		String sql="select * from customer ";
		try {
			QueryRunner runner=new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanListHandler<Customer>(Customer.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	/**
	 * 获取客户信息
	 */
	@Override
	public Customer findCustomerByid(String id) {
		// TODO Auto-generated method stub
		String sql="select * from customer where id=?";
		try {
			QueryRunner runner=new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanHandler<Customer>(Customer.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("客户信息获取失败");
		}
	}
	/**
	 * 根据id修改信息；
	 */
	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		String sql="update customer set name=?,gender=?,birthday=?,cellphone=?,email=?,preference=?,type=?,description=? where id=?";
		try {
			QueryRunner runner=new QueryRunner(DaoUtils.getSource());
			runner.update(sql,customer.getName(),customer.getGender(),customer.getBirthday(),customer.getCellphone(),customer.getEmail(),customer.getPreference(),customer.getType(),customer.getDescription(),customer.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	/**
	 * 删除客户
	 */
	@Override
	public void deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		String sql="delete from customer where id=?";
		try {
			QueryRunner runner=new QueryRunner(DaoUtils.getSource());
			runner.update(sql,customer.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	/**
	 * 带事务的批量删除
	 */
	@Override
	public void delCustByIDWithTrans(Connection conn, String id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from customer where id = ?";
		QueryRunner runner = new QueryRunner();
		runner.update(conn,sql,id);
	}
	/**
	 * 查询
	 */
	@Override
	public List<Customer> findCustByCond(Customer customer) {
		// TODO Auto-generated method stub
		String sql = "select * from customer where 1=1 ";
		List<Object> list = new ArrayList<Object>();
		if(customer.getName()!=null && !"".equals(customer.getName())){
			sql += " and name like ? ";
			list.add("%"+customer.getName()+"%");
		}
		if(customer.getGender()!=null && !"".equals(customer.getGender())){
			sql += " and gender = ? ";
			list.add(customer.getGender());
		}
		if(customer.getType()!=null && !"".equals(customer.getType())){
			sql += " and type = ? ";
			list.add(customer.getType());
		}
		
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			if(list.size()<=0){
				return runner.query(sql, new BeanListHandler<Customer>(Customer.class));
			}else{
				return runner.query(sql, new BeanListHandler<Customer>(Customer.class),list.toArray());
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	@Override
	public List<Customer> getCustByPage(int from, int count) {
		// TODO Auto-generated method stub
		String sql = "select * from customer limit ?,?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanListHandler<Customer>(Customer.class),from,count);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	//获取行数
	@Override
	public int getCountRow() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from customer";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return ((Long)runner.query(sql, new ScalarHandler())).intValue();
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	

	
}
