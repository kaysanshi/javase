package com.xiaoxiao.domain;

public class Address {
	private int addressid;//地址id
	private String addressname;//详细地址
	private String postcode;//邮编
	private String receiver;//收件人
	private String phone;//电话
	private int vipid;//购买者id
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	public String getAddressname() {
		return addressname;
	}
	public void setAddressname(String addressname) {
		this.addressname = addressname;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getVipid() {
		return vipid;
	}
	public void setVipid(int vipid) {
		this.vipid = vipid;
	}
	@Override
	public String toString() {
		return "Address [addressid=" + addressid + ", addressname="
				+ addressname + ", postcode=" + postcode + ", receiver="
				+ receiver + ", phone=" + phone + ", vipid=" + vipid + "]";
	}
}
