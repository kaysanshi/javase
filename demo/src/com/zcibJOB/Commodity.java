package com.zcibJOB;

public class Commodity {
	String name;
	String dateofproduction;
	Double price;
	String placeofproduction;
	public String getname(){
		return name;
	}
	public String getdate(){
		return dateofproduction;
	}
	public String getplace(){
		return  placeofproduction;
	}
	public Double getprice(){
		return price;
	}
//	有参的方法；
	public String getname(String name){
		 this.name=name;
		 return name;
	}
	public String getdate(String dateofproduction){
		this.dateofproduction=dateofproduction;
		return dateofproduction;
	}
	public String getplace(String placeofproduction){
		this.placeofproduction =placeofproduction;
		return  placeofproduction;
	}
	public Double getprice(Double price){
		return price;
	}
	

}
