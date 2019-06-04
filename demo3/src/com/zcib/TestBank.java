package com.zcib;

import java.util.Scanner;

public class TestBank {

	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		System.out.println("首次办理银行卡请你设置你的密码：");
		String code=scan.nextLine();
		System.out.println("请输入你的姓名：");
		String name=scan.nextLine();
		System.out.println("请输入密码：");
		String MIMA=scan.nextLine();
		SavingAccount p=new SavingAccount();
		p.setCode(code);
		p.setName(name);
		p.getMIMA(MIMA);
		System.out.println("请输入存款金额：如果你想用支票取款你必须输入-1进行支票取款：");
		float amount=scan.nextFloat();
		p.deposit(amount);
		p.getBalance(amount);
		if(MIMA.equals(p.getCode())){
			if(p.getBalance(amount)!=-1){
		System.out.println("你这的卡上余额为"+(p.getBalance(amount)));
			}
		if(p.getBalance(amount)==-1){
		System.out.println("你现在只能用支票进行取款：");
		CheckAccount s=new CheckAccount();
		System.out.println("请输入你的取款金额：");
		float amount1=scan.nextFloat();
		s.withdraw(amount1);
		scan.close();
		System.out.println("扣除手续费后你的实际支票取款金额为："+s.withdraw(amount1));
		System.out.println("你现在欠银行金额为："+s.amount1);
			}
		}
	}
}
