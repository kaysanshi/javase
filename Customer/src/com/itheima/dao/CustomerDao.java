package com.itheima.dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.itheima.domain.Customer;

public interface CustomerDao {
	/**
	 * 根据用户名查找用户
	 * @param name 用户名
	 * @return 找到的用户,如果找不到返回null
	 */
	Customer finduserByName(String name);

	/**
	 * 添加客户
	 * @param cust
	 */
	void addCustomer(Customer customer);
	/**
	 * 查询所有用户
	 * @return找到的用户,如果找不到返回null
	 */
	List<Customer> getAllCustomer();
	/**
	 * 通过id来获取信息
	 * @param id
	 * @return
	 */
	Customer findCustomerByid(String id);
	/**
	 * 修改信息
	 * @param customer
	 */
	void updateCustomer(Customer customer);
	/**
	 * 删除客户
	 * @param customer
	 */
	void deleteCustomer(Customer customer);
	
	/**
	 * 带事务的批量删除
	 * @param conn
	 * @param id
	 * @throws SQLException 
	 */
	void delCustByIDWithTrans(Connection conn, String id) throws SQLException;
	/**
	 * 查询的操作
	 * @param customer
	 * @return
	 */
	List<Customer> findCustByCond(Customer customer);
	/**
	 * 分页
	 * @param i
	 * @param rowperpage
	 * @return
	 */
	List<Customer> getCustByPage(int i, int rowperpage);
	/**
	 * 获取行数
	 * @return
	 */
	int getCountRow();
	
}
