package com.zcib2.job;
//ѧ����;
public class Student {
	private String stuName;//ѧ������
	private String stuId;//ѧ��
	private String stuclass;//ѧ���༶;
	
	public Student(String id,String name,String stuclass) {
		// TODO Auto-generated constructor stub
		this.stuId=id;
		this.stuName=name;
		this.stuclass=stuclass;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getStuclass() {
		return stuclass;
	}
	public void setStuclass(String stuclass) {
		this.stuclass = stuclass;
	}


}
