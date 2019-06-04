package com.lyq.persistence;

import java.util.Date;
/**
 * 药品持久化类
 * @author Li Yong Qiang
 */
public class Medicine {
	private int id;					//id号
	private String name;			//药品名称
	private String medNo;			//药品编码
	private String factoryAdd;		//出厂地址
	private String description;		//描述
	private double price;			//价格
	private int medCount;			//数量
	private int reqCount;			//需求数量
	private String photoPath ;		//图片
	private Date editTime;			//时间
	private Category category;		//类别
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMedNo() {
		return medNo;
	}
	public void setMedNo(String medNo) {
		this.medNo = medNo;
	}
	public String getFactoryAdd() {
		return factoryAdd;
	}
	public void setFactoryAdd(String factoryAdd) {
		this.factoryAdd = factoryAdd;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getMedCount() {
		return medCount;
	}
	public void setMedCount(int medCount) {
		this.medCount = medCount;
	}
	public int getReqCount() {
		return reqCount;
	}
	public void setReqCount(int reqCount) {
		this.reqCount = reqCount;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	public Date getEditTime() {
		return editTime;
	}
	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}
