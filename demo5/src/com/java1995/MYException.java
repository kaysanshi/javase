package com.java1995;

public class MYException {
	
	public static void main(String[] args) {
		MeException p=new MeException("自己的异常类");
		System.out.println(p.getMessage());
		System.out.println(p.toString());
	}
}
	class MeException extends Exception{
		public MeException(){
			
		}
		public MeException(String mas){
			super(mas);
		}
	}

