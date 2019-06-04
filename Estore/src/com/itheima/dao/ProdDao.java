package com.itheima.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.itheima.domain.Product;

public interface ProdDao  extends Dao{

	/**
	 * 添加商品
	 * @param prod
	 */
	void addProd(Product prod);

	/**
	 * 查询所有
	 * @return
	 */
	List<Product> findAllProd();

	/**
	 * 根据id查找商品
	 * @param id
	 * @return
	 */
	Product findProdById(String id);

	/**
	 * 扣除商品库存数量
	 * @param product_id
	 * @param buynum
	 * @throws SQLException 
	 */
	void delPnum(String product_id, int buynum) throws SQLException;

	/**
	 * 加回产品库存数量
	 * @param product_id
	 * @param buynum
	 */
	void addPnum(String product_id, int buynum);

}
