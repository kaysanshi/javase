package com.xiaoxiao.domain;

public class OrderItem {
	private int id;//订单条目编号
	private int buycount;//购买数量
	private float total;//购买该商品总价
	private Product product;//购买商品
	private Order order;//订单
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBuycount() {
		return buycount;
	}
	public void setBuycount(int buycount) {
		this.buycount = buycount;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", buycount=" + buycount + ", total="
				+ total 
				+ ", product=" + product 
				+ ", orderid=" + "]";
	}
	
}
