package com.xiaoxiao.domain;

import java.util.Date;
import java.util.List;

public class Order {
	
	private String orderid;//订单编号
	private float totalprice;//总价
	private Date ordertime;//下单时间
	private int status;//订单状态
	private User user;//下单会员id
	private Address address;//配送地址
	private List<OrderItem> orderItemList;//订单项列表
	
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public float getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
	@Override
	public String toString() {
		return "Order [ordersid=" + orderid + ", totalprice=" + totalprice
				+ ", ordertime=" + ordertime + ", status=" + status + ", user="
				+ user + ", address=" + address + ", orderItemList="
				+ orderItemList + "]";
	}

}
