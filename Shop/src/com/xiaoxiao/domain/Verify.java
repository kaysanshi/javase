package com.xiaoxiao.domain;

import java.util.Date;

public class Verify {
	private int activationid;//激活码
	private String code;//激活码
	private Date expiredate;//过期日期
	private int vipid;//用户vipid
	public int getActivationid() {
		return activationid;
	}
	public void setActivationid(int activationid) {
		this.activationid = activationid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getExpiredate() {
		return expiredate;
	}
	public void setExpiredate(Date expiredate) {
		this.expiredate = expiredate;
	}
	public int getVipid() {
		return vipid;
	}
	public void setVipid(int vipid) {
		this.vipid = vipid;
	}
	@Override
	public String toString() {
		return "Verify [activationid=" + activationid + ", code=" + code
				+ ", expiredate=" + expiredate + ", vipid=" + vipid + "]";
	}

}
