package com.zcib2.job1;

import java.io.Serializable;
//��Ӱ��λ��
public class MoiveSeat implements Serializable{
	private String seat;//��λ��;
	private String row;//��
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
