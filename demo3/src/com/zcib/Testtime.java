package com.zcib;

public abstract class Testtime {

	public static void main(String[] args) {
		 Time p=new Time();
		 p.setHour(20);
		 System.out.println(p.getHour());
		 p.setMinutes(70);
		 if(p.getMinutes()==-1){
			 System.out.println("����Ĳ����߼�!!!");
		 }else{
		 System.out.println(p.getMinutes());
		 }
	}

}
