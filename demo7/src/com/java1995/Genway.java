package com.java1995;

public class Genway {
//	���巺�ͷ�����ʽ��
//	���η�  �������� <���������б�> �������� ���������������б�
	public static <T> boolean compare(T[] ts,T t){
		//��ʼʱ����
		boolean compare=false;
		for(int i=0;i<ts.length;i++){
			//������ʱ��Ҫ��Ԫ�ص�ÿһ��ֵ�Ƚ�ts[i];
			if(t.equals(ts[i])){
				compare=true;
				break;
			}
		}
		return compare;
	}
	//���ͷ���
	
	/*
	 * ���͵Ĳ����ڵ��÷��ͷ���ʱ�Ǻ���������һ����
	 */
	public static void main(String[] args) {
		Integer[] i={1,2,3,5,6};
//	��������Ķ���ʱ�����ķ���ʱ��������
//	GenWay<Integer> s=new Genway<Integer>(i);
		boolean  s=compare( i,6);
		if(s){
			System.out.println("6���������i��");
		}else{
			System.out.println("��������i��");
		}
		String[] s1={"hello" ,"you" ,"are very ","beautiful"};
		boolean ss=compare(s1,"beautiful");
		if(ss){
			System.out.println("beautiful���������s1��");
		}else{
			System.out.println("beautiful��������s1��");
		}
	}
}
