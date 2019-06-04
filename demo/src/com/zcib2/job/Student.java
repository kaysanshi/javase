package com.zcib2.job;
//学生类;
public class Student {
	private String stuName;//学生姓名
	private String stuId;//学号
	private String stuclass;//学生班级;
	
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
