package com.zcib;
/*
 * ѧ����̳�person��
 */
public class Student extends Person {
	private String number;//ѧ��
	private String department;//ϵ��
	private double score;//�ɼ�
	private String password;//����
	private String grade;//�꼶
	String subject;//��Ŀ
	double subscore;//��Ŀ�ɼ�
	String Mima;
//	��ȡ��Ŀ�ķ���
	public String getSubject(String subject){
		this.subject=subject;
		return subject;
	}
//	��ȡ��Ŀ�ɼ��ķ���
	double getsubscore(double subscore){
			this.subscore=subscore;
		return subscore;
	}
//	��ȡ����ķ�����
	public String getMima(String Mima){
		this.Mima=Mima;
		return Mima;
	}
	/*
	 * ���췽��
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
	//�޲ι���
	public Student() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		
		  return 
		  	number +"\t"+name+"\t"+sex+"\t"+age+"\t"+address+"\t"+department 
					+"\t"+ score + "\t"+ grade + "\t" +subject + "\t"+subscore+"\n";
}
//	get set������
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
