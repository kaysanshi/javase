package com.zcib;

public class BankAccount {
	private String name;//�û���
	private String code;//����
	float balance;//���
	float amount;//���
	float amount1;//Ҫȡ�ý�
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
//	ȡ���
	private float withdraw(float amount1){
		this.amount1=amount1;
		return amount1;
	}
//	������
	public float deposit(float amount){
		this.amount=amount;
		return amount;
	}
//	��ȡ���ķ���
	public float getBalance(float amount){
		this.amount=amount;
		return balance=deposit(amount)-withdraw(amount1);
	}
}
