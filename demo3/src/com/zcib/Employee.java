package com.zcib;

public class Employee extends Person {
//	�̳еķ�ʽ��ʵ����Щ����
//	private String name;//����
	private String address;//��ַ
	private String phoneNumber;//�绰����
	String Number;//����
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
