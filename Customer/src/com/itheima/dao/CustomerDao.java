package com.itheima.dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.itheima.domain.Customer;

public interface CustomerDao {
	/**
	 * �����û��������û�
	 * @param name �û���
	 * @return �ҵ����û�,����Ҳ�������null
	 */
	Customer finduserByName(String name);

	/**
	 * ��ӿͻ�
	 * @param cust
	 */
	void addCustomer(Customer customer);
	/**
	 * ��ѯ�����û�
	 * @return�ҵ����û�,����Ҳ�������null
	 */
	List<Customer> getAllCustomer();
	/**
	 * ͨ��id����ȡ��Ϣ
	 * @param id
	 * @return
	 */
	Customer findCustomerByid(String id);
	/**
	 * �޸���Ϣ
	 * @param customer
	 */
	void updateCustomer(Customer customer);
	/**
	 * ɾ���ͻ�
	 * @param customer
	 */
	void deleteCustomer(Customer customer);
	
	/**
	 * �����������ɾ��
	 * @param conn
	 * @param id
	 * @throws SQLException 
	 */
	void delCustByIDWithTrans(Connection conn, String id) throws SQLException;
	/**
	 * ��ѯ�Ĳ���
	 * @param customer
	 * @return
	 */
	List<Customer> findCustByCond(Customer customer);
	/**
	 * ��ҳ
	 * @param i
	 * @param rowperpage
	 * @return
	 */
	List<Customer> getCustByPage(int i, int rowperpage);
	/**
	 * ��ȡ����
	 * @return
	 */
	int getCountRow();
	
}
