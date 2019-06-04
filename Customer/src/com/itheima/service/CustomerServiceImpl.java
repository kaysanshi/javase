package com.itheima.service;


import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;
import com.itheima.domain.Page;
import com.itheima.factory.BasicFactory;
import com.itheima.utils.DaoUtils;

public class CustomerServiceImpl implements CustomerService {
	CustomerDao dao=BasicFactory.getFactory().GetInstance(CustomerDao.class);
	/**
	 * 增加用户
	 */
	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		if(dao.finduserByName(customer.getName())!=null){
			throw new RuntimeException("用户名已存在");
		}
		dao.addCustomer(customer);
	}
	/**
	 * 查询所有用户；
	 * 调用dao层的getAllCustomer;
	 */
	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return dao.getAllCustomer();
	}
	/**
	 * 根据id来查询客户信息
	 */
	@Override
	public Customer findCustomerByid(String id) {
		// TODO Auto-generated method stub
		return dao.findCustomerByid(id);
	}
	/**
	 * 
	 */
	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		dao.updateCustomer(customer);
	}
	/**
	 * \
	 */
	@Override
	public void deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		dao.deleteCustomer(customer);
	}
	/**
	 *批量删除
	 */
	@Override
	public void batchdel(String[] ids) {
		// TODO Auto-generated method stub
		Connection conn = DaoUtils.getConnection();
		try{
			
			conn.setAutoCommit(false);
			for(String id : ids){
				dao.delCustByIDWithTrans(conn,id);
			}
			//提交事务并关闭
			DbUtils.commitAndCloseQuietly(conn);
		}catch (Exception e) {
			//异常的话回滚事务打印异常
			DbUtils.rollbackAndCloseQuietly(conn);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	/**
	 * 查询
	 */
	@Override
	public List<Customer> findCustomerByCond(Customer customer) {
		// TODO Auto-generated method stub
		return dao.findCustByCond(customer);
	}
	/**
	 * 分页
	 */
	@Override
	public Page pageCust(int thispage, int rowperpage) {
		// TODO Auto-generated method stub
		Page page = new Page();
		//--当前页
		page.setThispage(thispage);
		//--每页记录数
		page.setRowperpage(rowperpage);
		//--共有多少行
		int countrow = dao.getCountRow();
		page.setCountrow(countrow);
		//--共有多少页
		int countpage = countrow/rowperpage+(countrow%rowperpage==0?0:1);
		page.setCountpage(countpage);
		//--首页
		page.setFirstpage(1);
		//--尾页
		page.setLastpage(countpage);
		//--上一页
		page.setPrepage(thispage==1?1:thispage-1);
		//--下一页
		page.setNextpage(thispage == countpage ? countpage : thispage+1);
		//--当前页数据
		List<Customer> list = dao.getCustByPage((thispage-1)*rowperpage,rowperpage);
		page.setList(list);
		
		return page;
	}
}
