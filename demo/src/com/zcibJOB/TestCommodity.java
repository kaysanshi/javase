package com.zcibJOB;

public class TestCommodity {

	public static void main(String[] args) {
		Commodity p=new Commodity();
		p.name="����";
		p.dateofproduction ="2016.12";
		p.placeofproduction ="����֣��";
		p.price =10.2;
		System.out.println(p.getname() );
		System.out.println(p.getdate() );
		System.out.println(p.getplace() );
		System.out.println(p.getprice() );
		Commodity p1=new Commodity();
		System.out.println(p1.getdate("2006"));
		System.out.println(p1.getname("����"));
		System.out.println(p1.getplace("����"));
		System.out.println(p1.getprice(2.5));

	}

}
