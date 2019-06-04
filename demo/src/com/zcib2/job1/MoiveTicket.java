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
	//һ����ӡ�ķ���;
	public void printTicket(){
		System.out.println("��Ӱ��:"+moive.getName());
		System.out.println("����:"+moive.getmType());
		System.out.println("��ӳʱ��:"+mSchedule.getDate());
		System.out.println("Ӱ��:"+mSchedule.getMovienumber());
		System.out.println("��λ:"+mSeat.getRow()+"��"+mSeat.getSeat()+"��");
	}

}
