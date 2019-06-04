package com.lyq.struts.form;

import java.util.Date;

import org.apache.struts.action.ActionForm;
/**
 * 类别FormBean
 * @author Li Yong Qiang
 */
public class CategoryForm extends ActionForm {
	private static final long serialVersionUID = 1L;	//序列化
	private int id;				//类别编号
	private String name;		//类别名称
	private String description;	//类别描述
	private Date createTime;	//类别创建时间
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
