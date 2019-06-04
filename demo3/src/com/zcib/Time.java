package com.zcib;

public class Time {
//	·â×°£»
	private int hour;
	private int minutes;
	private int second;
	public void setHour(int hour){
		this.hour=hour;
	}
	public int getHour(){
		return hour;
	}
	public void setMinutes(int minutes){
		if(minutes<=60 && minutes>=0){
			this.minutes =minutes;
		}else{
			this.minutes=-1;
		}
	}
	public int getMinutes(){
		return minutes;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}

}
