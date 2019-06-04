package com.zcib.domain;

import java.io.Serializable;

/**
 * 新闻
 * @author 555
 *
 */
public class News implements Serializable{
	private int id;
	private String title;
	private String author;
	private String type;
	private String picturename;
	private String picturepath;
	private String content;
	private String uptime;
	private int upid;//添加者
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUptime() {
		return uptime;
	}
	public void setUptime(String uptime) {
		this.uptime = uptime;
	}
	public int getUpid() {
		return upid;
	}
	public void setUpid(int upid) {
		this.upid = upid;
	}
	public String getPicturename() {
		return picturename;
	}
	public void setPicturename(String picturename) {
		this.picturename = picturename;
	}
	public String getPicturepath() {
		return picturepath;
	}
	public void setPicturepath(String picturepath) {
		this.picturepath = picturepath;
	}
}
