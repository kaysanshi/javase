package com.zcib;

public class Student {
//	此代码用于描述封装的特点，其特点是通过封装来把属性隐藏然后通过set,get 方法把属性展现出来
//	用于操作可以不让外界人员对这些属性随意改动，
	private String name;
	private int age;
	private String id;
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
