package com.java1995;

public class NoGen {
//	û�з���  ����ת��������������
//	�з���ʱ�����ᵽ������
	private Object obj;
	NoGen(Object obj){
		this.obj=obj;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public void show(){
		System.out.println("��������ͣ�"+obj.getClass().getName());
	}
	/*
	 * 
	 */
	
	public static void main(String[] args) {
		Integer i=new Integer(10);
		NoGen n=new NoGen(i);
		n.show();
		//
		String s=new String("123");
		NoGen n1=new NoGen(s);
		n1.show();
		Integer i2=(Integer)n.getObj();
		String s2=(String)n1.getObj();
		//����ʱ�ͻ���ֲ���ȫ���������������ͨ��������ʱ����
		String s3=(String)n.getObj();
		System.out.println(i2+" "+s2+"");
		System.out.println(s3);
		
	}
}
