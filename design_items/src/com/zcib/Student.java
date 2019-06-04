package com.zcib;
/*
 * 学生类继承person类
 */
public class Student extends Person {
	private String number;//学号
	private String department;//系别
	private double score;//成绩
	private String password;//密码
	private String grade;//年级
	String subject;//科目
	double subscore;//科目成绩
	String Mima;
//	获取科目的方法
	public String getSubject(String subject){
		this.subject=subject;
		return subject;
	}
//	获取科目成绩的方法
	double getsubscore(double subscore){
			this.subscore=subscore;
		return subscore;
	}
//	获取密码的方法；
	public String getMima(String Mima){
		this.Mima=Mima;
		return Mima;
	}
	/*
	 * 构造方法
	 */
	public Student(String number,String name,String sex,int age,String address,String department,
							double score,String grade,String subject, double subscore){
		this.number=number;
		this.name=name;
		this.sex=sex;
		this.age=age;
		this.address=address;
		this.department=department;
		this.score=score;
		this.grade=grade;
		this.subject=subject;
		this.subscore=subscore;
		
	}
	//无参构造
	public Student() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		
		  return 
		  	number +"\t"+name+"\t"+sex+"\t"+age+"\t"+address+"\t"+department 
					+"\t"+ score + "\t"+ grade + "\t" +subject + "\t"+subscore+"\n";
}
//	get set方法；
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}	
}
