package com.zcib2.job1;

import java.io.Serializable;
import java.util.Set;
//��Ӱ��;
public class Moive implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;//��Ӱ��
	private MoiveType mType;//��Ӱ����;
	public Moive( MoiveType mType) {
		// TODO Auto-generated constructor stub
		this.mType=mType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MoiveType getmType() {
		return mType;
	}
	public void setmType(MoiveType mType) {
		this.mType = mType;
	}

}
