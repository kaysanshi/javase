package com.java1995;

public class Gen<T> {//T�����Ƕ�����
//�����ࣺ�����ǽ����Ͳ�����
//	���췽��
	T obj;
	Gen(T obj){
		this.obj=obj;	
	}
	
	public T getObj(){
		return obj;
	}
	public void Show(){
		System.out.println("������Ϣ��"+obj.getClass().getName());
	}
		/*
		 * ���͵�ʹ�ò��ԣ��������ͬ���͵Ķ�����ʱ�ᱨ��
		 * 
		 */
			public static void main(String[] args) {
				Integer i1= new Integer(1);
				Gen<Integer> g1=new Gen<Integer>(i1);
				System.out.println(g1.getObj());
				g1.Show();
				String s1=new String("java genericity");
				Gen<String> s=new Gen<String>(s1);
				System.out.println(s.getObj());
				s.Show();
			}
}
