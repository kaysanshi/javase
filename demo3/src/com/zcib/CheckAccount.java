package com.zcib;

public class CheckAccount extends BankAccount{
//	ȡ���
	public  float withdraw(float amount1){
		this.amount1=amount1;
		return amount1=(float) (amount1-1.25);
	}
}
