package com.xiaoxiao.domain;

import java.util.List;

public class Province {
	private int id;//主键
	private String provinceid;//省编号
	private String province;//省名称
	private List<City> cities;//下属城市
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	@Override
	public String toString() {
		return "Province [id=" + id + ", provinceid=" + provinceid
				+ ", province=" + province + ", cities=" + cities + "]";
	}
}
