package com.java1995;

public class ThrowException {

	public static void main(String[] args) {
		ThrowException t=new ThrowException();
		try{
			t.test();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}
	public void test() throws Exception{
		throw new Exception("手动抛出的异常");
		///throw new Exception("异常2");
	}

}
