package com.zcib;

public class Card {
	private String name;//姓名
	private String code;//第一次设置的密码
	 float balance;//余额
	 float amount;//金额
	 float money;//要冲值得钱
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
//	冲值得方法；
	public float recharge(float money){
		this.money=money;
		return money;
	}
//	支付的方法；
	public float pay(float amount){	
		this.amount=amount;
		return amount;
	}
//	获取余额的方法；
	public float getBalance(){
		return recharge(money)-pay(amount);
	}
}
