package com.xiaoxiao.service;

import java.sql.SQLException;
import java.util.List;

import com.xiaoxiao.dao.OrderDao;
import com.xiaoxiao.domain.Order;
import com.xiaoxiao.utils.JDBCUtils;

public class OrderService {
	private OrderDao orderDao = new OrderDao();

	public void add(Order order) {
		/*
		 * 1.调用OrderDao方法addOrder，使用事务添加Order
		 * 2.调用OrderDao方法addOrderItem，添加OrderItem列表
		 */
		try{
			JDBCUtils.beginTranscation();//开启事务
			orderDao.addOrder(order);
			orderDao.addOrderItem(order.getOrderItemList());
			JDBCUtils.commitTranscation();
			
		}catch(Exception e){
			try {
				System.out.println("huigun");
				e.printStackTrace();
				JDBCUtils.rollbackTranscation();//回滚事务
			} catch (SQLException e1) {
				throw new RuntimeException(e);
			}
		}
		
	}
	
	public List<Order> findAll(){
		return orderDao.findAll();
	}
}
