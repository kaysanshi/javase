package com.zcib2.job1;

import java.io.Serializable;
import java.util.Set;

public class MoiveTicket implements Serializable{
	private Moive moive;
	private MoiveSeat mSeat;
	private MoiveSchedule mSchedule;
	public MoiveTicket(Moive moive, MoiveSeat mSeat,MoiveSchedule mSchedule){
		this.moive=moive;
		this.mSeat=mSeat;
		this.mSchedule=mSchedule;
	}
	//一个打印的方法;
	public void printTicket(){
		System.out.println("电影名:"+moive.getName());
		System.out.println("类型:"+moive.getmType());
		System.out.println("放映时间:"+mSchedule.getDate());
		System.out.println("影厅:"+mSchedule.getMovienumber());
		System.out.println("座位:"+mSeat.getRow()+"排"+mSeat.getSeat()+"座");
	}

}
