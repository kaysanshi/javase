package com.zcib;

public class Pupil1 implements Pupil,Human {
		String name;
		public String Name(String name) {
			this.name=name;
			return name;
		}
		
	@Override
	public void eat() {
		System.out.println(name+"正在吃饭");
		
	}
	@Override
	public void sex() {
		// TODO Auto-generated method stub
		System.out.println(name+"性别未知");
	}

	@Override
	public void study() {
		// TODO Auto-generated method stub
		System.out.println("学生正在学习？");
	}
	@Override
	public void name() {
		// TODO Auto-generated method stub
		
	}
	

}
