package com.leo.domain;

import java.io.Serializable;
/**
 * 
 * @author leoi555
 *@date 2018Äê9ÔÂ5ÈÕ
 */
public class Address implements Serializable{
	private String province;   
    private String city;   
    private String country; 
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Address() {   
    }  
	public Address(String province, String city, String country){   
        this.province =province;   
        this.city = city;   
        this.country = country;   
    }   
}
