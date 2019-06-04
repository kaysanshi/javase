package com.zcib;

public class MMath implements Add,Jian,Cheng,Chu {

	@Override
	public int chu(int a, int b) {
		// TODO Auto-generated method stub
		return a/b;
	}

	@Override
	public int cheng(int a, int b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public int jian(int a, int b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

}
