package com.zcib.book.test;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
	public static void main(String[] args) {
		Map<String,String> person=new HashMap<String,String>();
		person.put("id", "1");
		person.put("name", "ÕÅÈı");
		person.put("sex", "ÄĞ");
		person.put("age", "25");
		person.put("love", "°®Ñ§java");
		System.out.println(person.keySet());
		System.out.print(person.values());
	

	}

}
