package com.mingribook;

public class TransferPropety {
	int i=47;//��Ա����
//	�����Ա����
	public void call(){
		System.out.println("����call����");
		for(i=0;i<3;i++){
			System.out.print(i+" ");
			if(i==2){
				System.out.println("\n");
			}
		}
	}
//	���幹�췽����
	public TransferPropety(){
		
	} 
	public static void main(String[] args) {
		TransferPropety  p=new TransferPropety ();
		TransferPropety  p1=new TransferPropety ();
		p.i=60;//�ı����Ա������ֵ��
		System.out.println("��һ�����õ���"+p.i++);
		p.call();
		System.out.println("�ڶ������õ���"+p1.i++);
		p1.call();
	}

}
