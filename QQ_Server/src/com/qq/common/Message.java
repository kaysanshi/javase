package com.qq.common;

import java.io.Serializable;
//�ͻ�����
//��һЩ����;1�ɹ�,2 ʧ��,3��ͨ����Ϣ
public class Message implements Serializable{
	private String meType;//��Ϣ������
	private String sender;//������;
	private String getter;//������;
	private String con;//��Ϣ���ݱ���
	private String sendtime;
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getGetter() {
		return getter;
	}

	public void setGetter(String getter) {
		this.getter = getter;
	}

	public String getCon() {
		return con;
	}

	public void setCon(String con) {
		this.con = con;
	}

	public String getSendtime() {
		return sendtime;
	}

	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

	public String getMeType() {
		return meType;
	}

	public void setMeType(String meType) {
		this.meType = meType;
	}

}
