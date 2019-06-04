package com.zcib2.job;
//成绩类
public class Grade {
	private String sId;//学号;
	private String cId;//课程编号;
	private double score;//分数;
	public Grade(String id,String cid,double score){
		this.sId=id;
		this.cId=cid;
		this.score=score;
		
	}
	public Grade() {
		// TODO Auto-generated constructor stub
	}
	public String getsId() {
		return sId;
	}
	public void setsId(String sId) {
		this.sId = sId;
	}
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
}
