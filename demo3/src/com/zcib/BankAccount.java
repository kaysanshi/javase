package com.zcib;

public class BankAccount {
	private String name;//用户名
	private String code;//密码
	float balance;//余额
	float amount;//金额
	float amount1;//要取得金额；
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
//	取款方法
	private float withdraw(float amount1){
		this.amount1=amount1;
		return amount1;
	}
//	存款方法；
	public float deposit(float amount){
		this.amount=amount;
		return amount;
	}
//	获取余额的方法
	public float getBalance(float amount){
		this.amount=amount;
		return balance=deposit(amount)-withdraw(amount1);
	}
}
