package com.java1995;

import java.io.Serializable;

/*
 * �������л�ʱҪ���ж�Serializable�ӿ�ʵ�֣�
 * �������ܰѶ���������л��Ĳ�����
 * ������transient�ؼ���������һЩ��Ϣ�����ᱻд�뵽�ļ������ܱ������ļ��У�
 */
public class Student implements Serializable{
	private String name;
	private String sex;
	private transient String age;
	@Override
	public String toString() {
		return "����:" + name + ", �Ա�" + sex + ", ���䣺" + age + ", ��ַ��" + address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String address;
	

}
