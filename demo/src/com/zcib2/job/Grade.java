package com.zcib2.job;
//�ɼ���
public class Grade {
	private String sId;//ѧ��;
	private String cId;//�γ̱��;
	private double score;//����;
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
