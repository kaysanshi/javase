package com.itheima.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.itheima.domain.Product;

public interface ProdDao  extends Dao{

	/**
	 * �����Ʒ
	 * @param prod
	 */
	void addProd(Product prod);

	/**
	 * ��ѯ����
	 * @return
	 */
	List<Product> findAllProd();

	/**
	 * ����id������Ʒ
	 * @param id
	 * @return
	 */
	Product findProdById(String id);

	/**
	 * �۳���Ʒ�������
	 * @param product_id
	 * @param buynum
	 * @throws SQLException 
	 */
	void delPnum(String product_id, int buynum) throws SQLException;

	/**
	 * �ӻز�Ʒ�������
	 * @param product_id
	 * @param buynum
	 */
	void addPnum(String product_id, int buynum);

}
