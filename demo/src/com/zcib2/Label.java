package com.zcib2;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Label implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
	while (true) {
		Date  date=new Date();
		// ��ʽ�� ���;
		String s="����ʱ�䣺yyy��MM��dd��,E,HH:mm:ss";
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
