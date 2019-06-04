package com.lyq.persistence;

import java.util.Date;
import java.util.Set;
/**
 * 药品类别持久化类
 * @author Li Yong Qiang
 */
public class Category {
	private int id;			//类别编号
	private String name;	//类别名称
	private String description;	//类别描述
	private String subDesc;		//类别描述的前10个字符
	private Date createTime;	//类别创建时间
	private Set meds;			//类别中的药品
	
	
	public String getSubDesc() {
		return subDesc;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
		//获取描述的前10个字符
		if(description.length() > 10){
			this.subDesc = description.substring(0,10) + "...";
		}else{
			this.subDesc = description;
		}
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Set getMeds() {
		return meds;
	}
	public void setMeds(Set meds) {
		this.meds = meds;
	}
}
