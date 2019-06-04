package com.itheima.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.itheima.annotation.Tran;
import com.itheima.domain.Order;
import com.itheima.domain.OrderItem;
import com.itheima.domain.SaleInfo;

public interface OrderDao extends Dao {

	/**
	 * 在订单表中插入记录
	 * @param order
	 * @throws SQLException 
	 */
	void addOrder(Order order) throws SQLException;

	/**
	 * 在订单项表中插入记录
	 * @param item
	 * @throws SQLException 
	 */
	void addOrderItem(OrderItem item) throws SQLException;

	/**
	 * 查询指定用户的所有订单
	 * @param user_id 要查询的用户id
	 * @return 所有这个用户订单信息组成的集合
	 */
	List<Order> findOrderByUserId(int user_id);

	/**
	 * 查询指定订单的所有订单项
	 * @param id
	 * @return
	 */
	List<OrderItem> findOrderItems(String id);

	/**
	 * 删除指定id订单所关联的所有订单项
	 * @param order_id 订单id
	 */
	void delOrderItem(String order_id);

	/**
	 * 删除指定id 的订单
	 * @param id
	 */
	void delOrder(String id);

	/**
	 * 根据id查询订单
	 * @param order_id
	 * @return
	 */
	Order finOrderById(String order_id);

	/**
	 * 修改订单支付状态
	 * @param order
	 * @param i
	 */
	void changePayState(String order, int i);

	/**
	 * 查询销售榜单
	 * @return
	 */
	List<SaleInfo> saleList();

}
