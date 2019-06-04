package com.zcib;
//父类中写公共的属性
public class People {
	private String name;
	private String sex;
	private String age;
	public void eat(){
		System.out.println("民以食为天");
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

}
