package com.xiaoxiao.domain;

import java.util.List;

public class City {
	private int id;//主键
	private String cityid;//市编号
	private String city;//市名称
	private Province province;//所属省
	private List<Area> areas;//所包含区
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	public List<Area> getAreas() {
		return areas;
	}
	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", cityid=" + cityid + ", city=" + city
				+ ", province=" + province + ", areas=" + areas + "]";
	}
}
