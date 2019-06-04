package com.zcib2.job1;

import java.io.Serializable;
//电影座位类
public class MoiveSeat implements Serializable{
	private String seat;//座位号;
	private String row;//行
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}
}
