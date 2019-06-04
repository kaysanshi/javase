package com.itheima.cookie;

import java.util.LinkedHashMap;
import java.util.Map;

import com.itheima.domain.Book;
///�൳��һ�����ݿ⣻
public class BookDao {
	private static Map<String, Book> bookmap=new LinkedHashMap<String,Book>();
	private BookDao(){
		
	}
	static{
		bookmap.put("1",new Book("1","����","it","88","����","����ɱ"));
		bookmap.put("2",new Book("2","ˮ�","����1","88","����","108����"));
		bookmap.put("3",new Book("3","����","����2","88","����","����ɶ"));
		bookmap.put("4",new Book("4","�̽�","����3","88","�̽�","�̽�ɶ"));
		
	}
	public static Map<String, Book> getbooks(){
		return bookmap;
	}
	public static Book getbook(String id){
		return bookmap.get(id);
	}
}
