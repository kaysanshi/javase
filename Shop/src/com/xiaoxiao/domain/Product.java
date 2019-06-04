package com.xiaoxiao.domain;

import java.util.Date;

public class Product {
	private int  productid;//id
	private String name;//名称
	private float price;//价格
	private float markprice;//市场价格
	private int quality;//库存量
	private int hit;//浏览量
	private Date time;//上架时间
	private String photo;//封面
	private String content;//描述
	private int categoryid;//分类
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getMarkprice() {
		return markprice;
	}
	public void setMarkprice(float markprice) {
		this.markprice = markprice;
	}
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", name=" + name
				+ ", price=" + price + ", markparice=" + markprice
				+ ", quality=" + quality + ", hit=" + hit + ", time=" + time
				+ ", photo=" + photo + ", content=" + content + ", categoryid="
				+ categoryid + "]";
	}
	

}
