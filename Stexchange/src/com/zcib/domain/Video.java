package com.zcib.domain;

import java.util.Date;

/**
 * 视频实体类
 * @author 555
 *@date 2018年5月8日
 */
public class Video {
	private int id;//主键
	private String uuidname;//
	private String videotitle;//标题
	private String description;//描述
	private String videopicture;//用于保存视频的截图
	private String uploadip;//上传者的ip
	private String savepath;//文件保存的位置
	private String uplaodteime;//上传时间
	private int uploadteacherid;//上传的教师的id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUuidname() {
		return uuidname;
	}
	public void setUuidname(String uuidname) {
		this.uuidname = uuidname;
	}
	public String getVideotitle() {
		return videotitle;
	}
	public void setVideotitle(String videotitle) {
		this.videotitle = videotitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getVideopicture() {
		return videopicture;
	}
	public void setVideopicture(String videopicture) {
		this.videopicture = videopicture;
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
	
	public int getUploadteacherid() {
		return uploadteacherid;
	}
	public void setUploadteacherid(int uploadteacherid) {
		this.uploadteacherid = uploadteacherid;
	}
	public String getUplaodteime() {
		return uplaodteime;
	}
	public void setUplaodteime(String uplaodteime) {
		this.uplaodteime = uplaodteime;
	}
	

}
