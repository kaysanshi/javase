package com.zcib;

public class Card {
	private String name;//����
	private String code;//��һ�����õ�����
	 float balance;//���
	 float amount;//���
	 float money;//Ҫ��ֵ��Ǯ
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
//	��ֵ�÷�����
	public float recharge(float money){
		this.money=money;
		return money;
	}
//	֧���ķ�����
	public float pay(float amount){	
		this.amount=amount;
		return amount;
	}
//	��ȡ���ķ�����
	public float getBalance(){
		return recharge(money)-pay(amount);
	}
}
