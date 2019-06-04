package com.zcib2;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Label implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
	while (true) {
		Date  date=new Date();
		// 格式化 输出;
		String s="北京时间：yyy年MM月dd日,E,HH:mm:ss";
		SimpleDateFormat f=new SimpleDateFormat(s);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(f.format(date));
		}
	}
}
