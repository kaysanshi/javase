package com.mingribook;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Timer;

public class AlarmClock {
//局部类的调用
	private int delay;
	private boolean flag;
	public AlarmClock(int delay,boolean flag){
		this.delay=delay;
		this.flag=flag;		
	}
	public void start(){
		class Printer implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("k:m:s:");
				DateFormat format = null;
				String result=format.format(new Date());
				System.out.println("当前时间是："+result);
				if(flag){
					Toolkit.getDefaultToolkit().beep();
				}
			}
		}
		new Timer(delay,new Printer()).start();
	}
	public static void main(String[] args) {
		AlarmClock m=new AlarmClock(20,false);
		m.start();
	}
}