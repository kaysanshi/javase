package com.java1995;

public class Object_finalize_Test {
//	����������������ǽ��飬�����������ﻹ����Java�����������
	private int id;
	public  Object_finalize_Test(int id){
		this.setId(id);
	}

	public static void main(String[] args) {
		for(int i=0;i<100000000;i++){
			new Object_finalize_Test(i);
//			System.gc();//�����������������
		}

	}
	public void finalize(){
		System.out.println(id+"���ڴ�������");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
