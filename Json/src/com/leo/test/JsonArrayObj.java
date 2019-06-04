package com.leo.test;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * 演示json的JSONObject,JSONArray,对应的是map和List
 * 如果想将对象转换成JOSN，或将JSON转换成对象，你需要考虑使用Jackson或Gson。
 * @author leoi555
 *@date 2018年9月5日
 */
public class JsonArrayObj {
	public static void main(String[] args) {
		//json解析的函数在goole的
		JSONParser parser=new JSONParser();
		 String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
		try {
			Object obj=parser.parse(s);
			
			
			JSONArray array=(JSONArray)obj;
			System.out.println(array.get(1));
			System.out.println();
			
			
			JSONObject object2=(JSONObject)array.get(1);
			System.out.println("Filed\"\"");
			System.out.println(object2.get("1"));
			s = "{}";
            obj = parser.parse(s);
            System.out.println(obj);

            s= "[5,]";
            obj = parser.parse(s);
            System.out.println(obj);

            s= "[5,,2]";
            obj = parser.parse(s);
            System.out.println(obj);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("position: " + e.getPosition());
            System.out.println(e);
		}
	}
}
