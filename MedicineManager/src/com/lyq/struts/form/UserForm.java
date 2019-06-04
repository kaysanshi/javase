package com.lyq.struts.form;

import java.util.Date;

import org.apache.struts.action.ActionForm;
/**
 * 用户FormBean
 * @author Li Yong Qiang
 */
public class UserForm extends ActionForm {

	private static final long serialVersionUID = 1L;	//序列化
	private int id;				//id号
	private String username;	//用户名
	private String password;	//密码
	private String oldPassword;	//原密码（修改密码用）
	private String rePassword;	//确认密码
	private Date createTime;	//创建时间
	
	
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
