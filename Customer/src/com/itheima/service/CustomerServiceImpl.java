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
	 * �����û�
	 */
	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		if(dao.finduserByName(customer.getName())!=null){
			throw new RuntimeException("�û����Ѵ���");
		}
		dao.addCustomer(customer);
	}
	/**
	 * ��ѯ�����û���
	 * ����dao���getAllCustomer;
	 */
	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return dao.getAllCustomer();
	}
	/**
	 * ����id����ѯ�ͻ���Ϣ
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
	 *����ɾ��
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
			//�ύ���񲢹ر�
			DbUtils.commitAndCloseQuietly(conn);
		}catch (Exception e) {
			//�쳣�Ļ��ع������ӡ�쳣
			DbUtils.rollbackAndCloseQuietly(conn);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	/**
	 * ��ѯ
	 */
	@Override
	public List<Customer> findCustomerByCond(Customer customer) {
		// TODO Auto-generated method stub
		return dao.findCustByCond(customer);
	}
	/**
	 * ��ҳ
	 */
	@Override
	public Page pageCust(int thispage, int rowperpage) {
		// TODO Auto-generated method stub
		Page page = new Page();
		//--��ǰҳ
		page.setThispage(thispage);
		//--ÿҳ��¼��
		page.setRowperpage(rowperpage);
		//--���ж�����
		int countrow = dao.getCountRow();
		page.setCountrow(countrow);
		//--���ж���ҳ
		int countpage = countrow/rowperpage+(countrow%rowperpage==0?0:1);
		page.setCountpage(countpage);
		//--��ҳ
		page.setFirstpage(1);
		//--βҳ
		page.setLastpage(countpage);
		//--��һҳ
		page.setPrepage(thispage==1?1:thispage-1);
		//--��һҳ
		page.setNextpage(thispage == countpage ? countpage : thispage+1);
		//--��ǰҳ����
		List<Customer> list = dao.getCustByPage((thispage-1)*rowperpage,rowperpage);
		page.setList(list);
		
		return page;
	}
}
