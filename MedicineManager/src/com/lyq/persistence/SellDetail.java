package com.lyq.persistence;

import java.util.Date;
/**
 * 销售明细持久化类
 * @author Li Yong Qiang
 */
public class SellDetail {
	private int id;				//编号
	private String sellName;	//药品名称
	private double sellPrice;	//价格
	private int sellCount;		//数量
	private Date sellTime;		//时间
	private Medicine med;		//药品
	private User user;			//操作人员
	private double sellTotal;	//总额(自动计算没有set方法)
	public double getSellTotal() {
		//计算总额
		if(this.sellCount > 0 && this.sellPrice > 0){
			this.sellTotal = this.sellPrice * this.sellCount;
		}
		return sellTotal;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getSellName() {
		return sellName;
	}
	public void setSellName(String sellName) {
		this.sellName = sellName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getSellTime() {
		return sellTime;
	}
	public void setSellTime(Date sellTime) {
		this.sellTime = sellTime;
	}
	public double getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}
	public int getSellCount() {
		return sellCount;
	}
	public void setSellCount(int sellCount) {
		this.sellCount = sellCount;
	}
	public Medicine getMed() {
		return med;
	}
	public void setMed(Medicine med) {
		this.med = med;
	}
}
