package com.zcib;

public class Employee extends Person {
//	继承的方式来实现这些问题
//	private String name;//姓名
	private String address;//地址
	private String phoneNumber;//电话号码
	String Number;//工号
	double salary;
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getNumber() {
		return Number;
	}
	public void setNumber(String number) {
		Number = number;
	}
	public double getSalary(double salary){
		this.salary=salary;
		return salary;
	}

}
