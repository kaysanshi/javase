package com.zcib.book.test;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
	public static void main(String[] args) {
		Map<String,String> person=new HashMap<String,String>();
		person.put("id", "1");
		person.put("name", "����");
		person.put("sex", "��");
		person.put("age", "25");
		person.put("love", "��ѧjava");
		System.out.println(person.keySet());
		System.out.print(person.values());
	

	}

}
