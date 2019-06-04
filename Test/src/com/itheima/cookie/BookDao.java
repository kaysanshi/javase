package com.itheima.cookie;

import java.util.LinkedHashMap;
import java.util.Map;

import com.itheima.domain.Book;
///相党于一个数据库；
public class BookDao {
	private static Map<String, Book> bookmap=new LinkedHashMap<String,Book>();
	private BookDao(){
		
	}
	static{
		bookmap.put("1",new Book("1","三国","it","88","北京","三国杀"));
		bookmap.put("2",new Book("2","水浒","作者1","88","北京","108单将"));
		bookmap.put("3",new Book("3","西游","作者2","88","西游","妖怪啥"));
		bookmap.put("4",new Book("4","碧江","作者3","88","碧江","碧江啥"));
		
	}
	public static Map<String, Book> getbooks(){
		return bookmap;
	}
	public static Book getbook(String id){
		return bookmap.get(id);
	}
}
