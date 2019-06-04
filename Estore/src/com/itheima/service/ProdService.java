package com.itheima.service;

import java.util.List;

import com.itheima.domain.Product;

public interface ProdService  extends Service{

	/**
	 * 添加商品
	 * @param prod 商品信息bean
	 */
	void addProd(Product prod);

	/**
	 * 查询所有商品
	 * @return
	 */
	List<Product> findAllProd();

	/**
	 * 根据id查找商品信息
	 * @param id
	 * @return
	 */
	Product findProdById(String id);

}
