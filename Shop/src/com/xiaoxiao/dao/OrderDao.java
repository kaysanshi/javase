package com.xiaoxiao.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.xiaoxiao.domain.Address;
import com.xiaoxiao.domain.Order;
import com.xiaoxiao.domain.OrderItem;
import com.xiaoxiao.domain.Product;
import com.xiaoxiao.domain.User;
import com.xiaoxiao.utils.BeanUtils;
import com.xiaoxiao.utils.JDBCUtils;

public class OrderDao {

	public void addOrder(Order order) {
		String sql = "insert into orders values(?,?,?,?,?,?,?,?,?)";
		
		Object params[]={
				order.getOrderid(),order.getTotalprice(),new java.sql.Date(order.getOrdertime().getTime()),
				order.getStatus(),order.getAddress().getAddressname(),order.getAddress().getPostcode(),
				order.getAddress().getReceiver(),order.getAddress().getPhone(),
				order.getUser().getVipid()
		};
		JDBCUtils.insert(sql, params);
		
	}

	public void addOrderItem(List<OrderItem> orderItemList) {
		String sql = "insert into orderItem values(null,?,?,?,?,?,?,?)";
		//定义一个二维数组，可以看做是一个一维数组，每一个元素也是一个一维数组
		//这个二维数组放置n条记录的参数
		Object params[][] = new Object[orderItemList.size()][];
		for(int i=0;i<orderItemList.size();i++){
			OrderItem item = orderItemList.get(i);
			params[i] = new Object[]{
					item.getBuycount(),item.getTotal(),item.getProduct().getProductid(),item.getProduct().getName(),
					item.getProduct().getPrice(),item.getProduct().getPhoto(),item.getOrder().getOrderid(),
			};
		}
		
		List<Number> keys = JDBCUtils.insertbatch(sql, params);
		for(int i=0;i<orderItemList.size();i++){
			OrderItem item = orderItemList.get(i);
			item.setId((keys.get(i)).intValue());
		}
		
	}
	
	//通过id查找Order
	public Order findOrderById(String orderid){
		String sql = "select * from orders where orderid = ?";
		Map<String,Object> map = JDBCUtils.select(sql, orderid).get(0);
		
		Order order = new Order();
		order.setOrderid(orderid);
		order.setOrdertime((Date) map.get("ordertime"));
		order.setStatus((Integer) map.get("status"));
		order.setTotalprice((Float) map.get("totalprice"));
		
		User user = new User();
		user.setVipid((Integer) map.get("vip"));
		order.setUser(user);
		
		Address address = new Address();
		address.setAddressname((String) map.get("addressname"));
		address.setPhone((String) map.get("phone"));
		address.setPostcode((String) map.get("postcode"));
		address.setReceiver((String) map.get("receiver"));		
		order.setAddress(address);
		
		order.setOrderItemList(findOrderItemList(order));
		
		return order;
	}
	
	//通过订单id查找OrderItem列表
	public  List<OrderItem> findOrderItemList(Order order){
		String sql = "select * from orderitem where orderid = ?";
		List<Map<String,Object>> list = JDBCUtils.select(sql, order.getOrderid());
		List<OrderItem> itemlist = new ArrayList<OrderItem>();
		for(Map<String,Object> map:list){
			//每一个map就是一条OrderItem
			OrderItem orderItem = new OrderItem();
			orderItem.setBuycount((Integer) map.get("buycount"));
			orderItem.setId((Integer) map.get("id"));
			orderItem.setTotal((Float) map.get("total"));
			
			Product product = new Product();
			product.setProductid((Integer) map.get("productid"));
			product.setName((String) map.get("name"));
			product.setPrice((Float) map.get("price"));
			product.setPhoto((String) map.get("photo"));
			orderItem.setProduct(product);
			
			orderItem.setOrder(order);
			
			itemlist.add(orderItem);
		}
		return itemlist;
	}

	public List<Order> findAll() {
		//读取所有Order，放入到List列表
				String sql = "select * from orders order by ordertime";
				List<Map<String,Object>> orders = JDBCUtils.select(sql);
				//依次读取每一个Order
				List<Order> orderlist = new ArrayList<Order>();
				for(int k=0;k<orders.size();k++){
					Order order = null;
					Map<String,Object> map = orders.get(k);
					//将map转为order
					try {
						order = BeanUtils.toBean(map, Order.class);
						User user = BeanUtils.toBean(map, User.class);
						Address address = BeanUtils.toBean(map, Address.class);
						order.setUser(user);
						order.setAddress(address);
						//由order对象获取OrderItem列表
						sql = "select * from orderitem where orderid=?";
						List<Map<String,Object>> orderitems = JDBCUtils.select(sql, order.getOrderid());
						List<OrderItem> orderItemList = new ArrayList<OrderItem>();
						//取出存放了每一个orderitem的map，然后转为orderitem对象
						for(int i=0;i<orderitems.size();i++){
							Map<String,Object> map2 = orderitems.get(i);
							OrderItem orderItem = BeanUtils.toBean(map2, OrderItem.class);
							Product product = BeanUtils.toBean(map2, Product.class);
							orderItem.setProduct(product);
							orderItem.setOrder(order);
							orderItemList.add(orderItem);
						}
						order.setOrderItemList(orderItemList);
						orderlist.add(order);
					}  catch (Exception e) {
						throw new RuntimeException(e);
					} 
					
				}
				
				return orderlist;
	}
	
	
}
