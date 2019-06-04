package com.itheima.service;

import java.util.List;

import com.itheima.annotation.Tran;
import com.itheima.domain.Order;
import com.itheima.domain.OrderListForm;
import com.itheima.domain.SaleInfo;

public interface OrderService extends Service{

	/**
	 * 增加订单
	 * @param order 订单bean
	 */
	@Tran
	void addOrder(Order order);

	/**
	 * 查询指定用户所有订单的方法
	 * @param user_id
	 * @return 查找到的数据
	 */
	List<OrderListForm> findOrders(int user_id);

	/**
	 * 根据订单编号删除订单
	 * @param id
	 */
	@Tran
	void delOrderByID(String id);

	/**
	 * 根据id查询订单
	 * @param order
	 * @return
	 */
	Order findOrderById(String order);

	/**
	 * 修改指定id订单的支付状态
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
