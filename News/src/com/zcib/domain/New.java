package com.zcib.domain;

import java.util.Date;

public class New {
	private int id;//新闻id
	private String title;//新闻标题
	private String author;//作者
	private String content;//内容
	private Date publishedDate;//发布时间
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	@Override
	public String toString() {
		return "New [id=" + id + ", title=" + title + ", author=" + author
				+ ", content=" + content + ", publishedDate=" + publishedDate
				+ "]";
	}
}
