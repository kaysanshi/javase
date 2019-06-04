package com.lyq.struts.form;

import java.util.Date;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;
/**
 * 药品FormBean
 * @author Li Yong Qiang
 */
public class MedicineForm extends ActionForm{
	private static final long serialVersionUID = 1L;
	private int id;				//药品id号
	private String medNo;		//药品编码
	private String name;		//药品名称
	private String factoryAdd;	//出厂地址
	private String description;	//描述
	private double price;		//价格
	private int medCount;		//库存数量
	private int reqCount;		//需求数量
	private FormFile photo ;	//图片
	private String photoPath;	//图片路径
	private Date editDate;		//时间
	private int categoryId;		//所属类别
	public int getReqCount() {
		return reqCount;
	}
	public void setReqCount(int reqCount) {
		this.reqCount = reqCount;
	}
	public Date getEditDate() {
		return editDate;
	}
	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}
	public String getMedNo() {
		return medNo;
	}
	public void setMedNo(String medNo) {
		this.medNo = medNo;
	}
	public int getMedCount() {
		return medCount;
	}
	public void setMedCount(int medCount) {
		this.medCount = medCount;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
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
	public FormFile getPhoto() {
		return photo;
	}
	public void setPhoto(FormFile photo) {
		this.photo = photo;
	}
	
}
