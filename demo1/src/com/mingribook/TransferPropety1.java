package com.mingribook;

public class TransferPropety1 {
//	static ����ĳ�Ա������ֵ���Ա�����������๲��
	 static int i=47;//��̬��Ա����
//	�����Ա����
	public void call(){
		System.out.println("����call����");
		for(i=0;i<3;i++){
			System.out.print(i+" ");
			if(i==2){
				System.out .println("\n");
			}
		}
	}
//	���幹�췽����
	public TransferPropety1(){
		
	} 
	public static void main(String[] args) {
		TransferPropety1  p=new TransferPropety1 ();
		TransferPropety1 p1=new TransferPropety1 ();
		p.i=60;//�ı����Ա������ֵ��
		System.out.println("��һ�����õ���"+p.i++);
		p.call();
		System.out.println("�ڶ������õ���"+p1.i);
		p1.call();
//		��Ҫ���þ�̬�ĳ�Ա�����������·���
		System.out.println(TransferPropety1.i);
	}


}
