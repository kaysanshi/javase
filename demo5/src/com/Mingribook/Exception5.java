package com.Mingribook;

public class Exception5 {
//	�����쳣���ɿ�ʽ��
	 int num=60;
	public int setNum(int num){
		this.num=num;
		return num;
	}
//	��Ĺ��췽��
	public Exception5(){
		try{
			Class.forName("com.mingribook.Test");//װ�������
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		System.out.println("���ԣ�");
	}
	public static void main(String[] args) {
		Exception5 p=new Exception5();
		p.setNum(1258);
		System.out.println(p.setNum(1258));
	}

}
