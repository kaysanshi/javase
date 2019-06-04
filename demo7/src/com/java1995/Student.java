package com.java1995;

import java.io.Serializable;

/*
 * 对象序列化时要进行对Serializable接口实现；
 * 这样才能把对象进行序列化的操作；
 * 其中有transient关键字来保护一些信息；不会被写入到文件；不能被读到文件中；
 */
public class Student implements Serializable{
	private String name;
	private String sex;
	private transient String age;
	@Override
	public String toString() {
		return "姓名:" + name + ", 性别：" + sex + ", 年龄：" + age + ", 地址：" + address;
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
