package com.zcib2.job;
//�γ̵���
public class Course {
	private String courseId;//�γ̱��
	private String courseName;//����;
	public Course(String id,String name) {
		// TODO Auto-generated constructor stub
		this.courseId=id;
		this.courseName=name;
	}
	public Course() {
		// TODO Auto-generated constructor stub
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
}
