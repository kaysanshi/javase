package com.zcib.domain;

import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * 交流的实体类
 * @author 555
 *@date 2018年5月8日
 */
public class Exchangearea {
	private int id;
	private String title;//问题名
	private String content;//问题内容
	private String reply;//回复内容
	private Date replydate;//回复时间
	private int teacherid;//教师id
	private int studentid;//学生id;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public Date getReplydate() {
		return replydate;
	}
	public void setReplydate(Date replydate) {
		this.replydate = replydate;
	}
	public int getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

}
