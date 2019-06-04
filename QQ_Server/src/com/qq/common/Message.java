package com.qq.common;

import java.io.Serializable;
//客户端上
//定一些规则;1成功,2 失败,3普通的消息
public class Message implements Serializable{
	private String meType;//信息的类型
	private String sender;//发送者;
	private String getter;//接受者;
	private String con;//信息内容本身
	private String sendtime;
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getGetter() {
		return getter;
	}

	public void setGetter(String getter) {
		this.getter = getter;
	}

	public String getCon() {
		return con;
	}

	public void setCon(String con) {
		this.con = con;
	}

	public String getSendtime() {
		return sendtime;
	}

	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

	public String getMeType() {
		return meType;
	}

	public void setMeType(String meType) {
		this.meType = meType;
	}

}
