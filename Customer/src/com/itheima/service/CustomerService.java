package com.itheima.service;

import java.util.List;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;
import com.itheima.domain.Page;
import com.itheima.factory.BasicFactory;


public interface CustomerService {
	
	/**
	 * ��ӿͻ�
	 * @param cu
	 */
	void addCustomer(Customer customer);
	/**
	 * ��ȡ�б�
	 * @return
	 */
	List<Customer> getAllCustomer();
	/**
	 * ͨ��id��ȡ��Ϣ
	 * @param id
	 * @return
	 */
	Customer findCustomerByid(String id);
	/**
	 * �޸�
	 * @param customer
	 */
	void updateCustomer(Customer customer);
	/**
	 * ɾ��
	 * @param customer
	 */
	void deleteCustomer(Customer customer);
	/**
	 * ����ɾ��
	 * @param ids
	 */
	void batchdel(String[] ids);
	/**
	 * ��ѯ�ͻ�
	 * @param 
	 * @return
	 */
	List<Customer> findCustomerByCond(Customer customer);
	/**
	 * ��ҳ
	 * @param thispage
	 * @param rowperpage
	 * @return
	 */
	Page pageCust(int thispage, int rowperpage);
}
  