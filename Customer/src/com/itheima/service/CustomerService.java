package com.itheima.service;

import java.util.List;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;
import com.itheima.domain.Page;
import com.itheima.factory.BasicFactory;


public interface CustomerService {
	
	/**
	 * 添加客户
	 * @param cu
	 */
	void addCustomer(Customer customer);
	/**
	 * 获取列表
	 * @return
	 */
	List<Customer> getAllCustomer();
	/**
	 * 通过id获取信息
	 * @param id
	 * @return
	 */
	Customer findCustomerByid(String id);
	/**
	 * 修改
	 * @param customer
	 */
	void updateCustomer(Customer customer);
	/**
	 * 删除
	 * @param customer
	 */
	void deleteCustomer(Customer customer);
	/**
	 * 批量删除
	 * @param ids
	 */
	void batchdel(String[] ids);
	/**
	 * 查询客户
	 * @param 
	 * @return
	 */
	List<Customer> findCustomerByCond(Customer customer);
	/**
	 * 分页
	 * @param thispage
	 * @param rowperpage
	 * @return
	 */
	Page pageCust(int thispage, int rowperpage);
}
  