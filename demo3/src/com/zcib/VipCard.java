package com.zcib;

public class VipCard  extends Card{
	 String password;//√‹¬Î
	 float discount;//’€ø€
	 float amount1;
	 float balance=1000;
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	
	public float setDiscount(float discount) {
		this.discount = discount;
		return discount;
	}
	
	public float pay(float amount1){
			this.amount1=amount1;
			this.getPassword();
		return amount1*setDiscount(discount);
	}
	public float getbalance(float amount1){
		this.amount1=amount1;
		return balance-pay(amount1);
	}
	
	
}
