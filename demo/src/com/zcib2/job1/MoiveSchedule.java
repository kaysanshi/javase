package com.zcib2.job1;

import java.io.Serializable;
//��ӳ����;
public class MoiveSchedule implements Serializable{
	private String Movienumber;//��ӳ����;
	private String date;//��ӳʱ��;
	public String getMovienumber() {
		return Movienumber;
	}

	public void setMovienumber(String movienumber) {
		Movienumber = movienumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
