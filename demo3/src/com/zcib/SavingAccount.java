package com.zcib;

public class SavingAccount extends BankAccount {
	String MIMA;
	public String getMIMA(String MIMA){
		this.MIMA=MIMA;
		return MIMA;
	}
	public float deposit(float amount){
//		�ڴ�Ҫ��str.equal(sub)�����Ƚ϶����Ƿ���ͬ��
		if(MIMA.equals(getCode())){
//			System.out.println("������Ĵ����Ϊ��"+amount);
			this.amount=amount;	
		}else {
//		�˴�������벻��ȷ��η��ص���������Ĵ��봦�أ���
		System.out.println("����������벻��ȷ����������");
		 this.getMIMA(MIMA);
	} 
		return amount;
	}

}
