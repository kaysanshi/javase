package com.zcib;

import java.util.Scanner;

public class TestCard {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入你的姓名");
		String name=scan.nextLine();
		System.out.println("请设置你的密码");
		String code=scan.nextLine();
		Card p=new Card();
		p.setName(name);
////		System.out.println();
		p.setCode(code);
//		System.out.println(p.getCode());	
		System.out.println("你好你是贵宾卡(1)还是普通卡(0)");{
		int a=scan.nextInt();
			if(a==0){
				System.out.println("请输入充值的金额：");
				float money=scan.nextFloat();
				System.out.println("恭喜"+p.getName()+"先生/女士充值成功卡上余额为："+p.recharge(money));
				System.out.println("请输入你此次购物的金额：");
				float amount=scan.nextFloat();
				p.pay(amount);
		System.out.println("你这次共花费的金额为："+p.pay(amount));
		System.out.println("你的余额为："+p.getBalance()+"欢迎下次光临！！！");
		}else{
				VipCard m=new VipCard();
				System.out.println("请输入你此次购物的金额：");
				float amount1=scan.nextFloat();
				System.out.println("请输入折扣：");
				 float discount=scan.nextFloat();
				 m.setDiscount(discount);
				 System.out.println("请输入你的密码：");
				 String password=scan.next();
				 m.setPassword(password);
					if(m.getPassword().equals(p.getCode())){
						m.getbalance(amount1);
				System.out.println("你的余额： "+m.getbalance(amount1));
					scan.close();
				}else{
					System.out.println("你输入的密码有误请重新输入!!!");
				}
					
			}
		}
	}
}
