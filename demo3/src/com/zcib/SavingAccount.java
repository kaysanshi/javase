package com.zcib;

public class SavingAccount extends BankAccount {
	String MIMA;
	public String getMIMA(String MIMA){
		this.MIMA=MIMA;
		return MIMA;
	}
	public float deposit(float amount){
//		在此要用str.equal(sub)方法比较二者是否相同；
		if(MIMA.equals(getCode())){
//			System.out.println("你输入的存款金额为："+amount);
			this.amount=amount;	
		}else {
//		此处如果密码不正确如何返回到输入密码的代码处呢？？
		System.out.println("你输入的密码不正确请重新输入");
		 this.getMIMA(MIMA);
	} 
		return amount;
	}

}
