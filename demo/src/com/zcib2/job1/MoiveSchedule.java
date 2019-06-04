package com.zcib2.job1;

import java.io.Serializable;
//放映场次;
public class MoiveSchedule implements Serializable{
	private String Movienumber;//放映场次;
	private String date;//放映时间;
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
