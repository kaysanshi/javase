package com.zcib.domain;
/**
 * 文件类
 * @author 555
 *@date 2018年5月8日
 */
public class Files {
	private int id;//主键
	private String uuidname;//服务器的uuid名
	private String filetitle;
	private String realname;//真实名字
	private String uploadip;//上传这IP
	private String savepath;//文件保存的路径
	private String description;//描述
	private String uploadtime;//上传时间
	private int uploadteacherid;//教师id;
	public int getId() {
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getUuidname() {
		return uuidname;
	}
	public void setUuidname(String uuidname) {
		this.uuidname = uuidname;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getUploadip() {
		return uploadip;
	}
	public void setUploadip(String uploadip) {
		this.uploadip = uploadip;
	}
	public String getSavepath() {
		return savepath;
	}
	public void setSavepath(String savepath) {
		this.savepath = savepath;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUploadtime() {
		return uploadtime;
	}
	public void setUploadtime(String uploadtime) {
		this.uploadtime = uploadtime;
	}
	public int getUploadteacherid() {
		return uploadteacherid;
	}
	public void setUploadteacherid(int uploadteacherid) {
		this.uploadteacherid = uploadteacherid;
	}
	public String getFiletitle() {
		return filetitle;
	}
	public void setFiletitle(String filetitle) {
		this.filetitle = filetitle;
	}
	
}
