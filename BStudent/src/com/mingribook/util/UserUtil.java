package com.mingribook.util;

public class UserUtil {
	private int popedom;
	static int n;
	public int getPopedom() {
		return popedom;
	}

	public void setPopedom(int popedom) {
		this.popedom = popedom;
		n=popedom;
	}
	public static int getNumber(){
		return n;
	}

}
