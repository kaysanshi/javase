package com.java1995;

public class Object_finalize_Test {
//	这里面的两个方法是建议，至于清理不清里还是有Java虚拟机决定的
	private int id;
	public  Object_finalize_Test(int id){
		this.setId(id);
	}

	public static void main(String[] args) {
		for(int i=0;i<100000000;i++){
			new Object_finalize_Test(i);
//			System.gc();//建议虚拟机清理垃圾
		}

	}
	public void finalize(){
		System.out.println(id+"正在处理垃圾");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
