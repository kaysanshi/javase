package com.java1995;

public class MYException {
	
	public static void main(String[] args) {
		MeException p=new MeException("�Լ����쳣��");
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

