package com.zcib;

public class Pupil1 implements Pupil,Human {
		String name;
		public String Name(String name) {
			this.name=name;
			return name;
		}
		
	@Override
	public void eat() {
		System.out.println(name+"���ڳԷ�");
		
	}
	@Override
	public void sex() {
		// TODO Auto-generated method stub
		System.out.println(name+"�Ա�δ֪");
	}

	@Override
	public void study() {
		// TODO Auto-generated method stub
		System.out.println("ѧ������ѧϰ��");
	}
	@Override
	public void name() {
		// TODO Auto-generated method stub
		
	}
	

}
