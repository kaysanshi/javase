package com.xiaoxiao.domain;

public class Area {
	private int id;//主键
	private String areaid;//区编号
	private String area;//区名称
	private City city;//所属城市
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAreaid() {
		return areaid;
	}
	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Area [id=" + id + ", areaid=" + areaid + ", area=" + area
				+ ", city=" + city + "]";
	}
}
