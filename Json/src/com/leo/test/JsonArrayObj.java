package com.leo.test;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * ��ʾjson��JSONObject,JSONArray,��Ӧ����map��List
 * ����뽫����ת����JOSN����JSONת���ɶ�������Ҫ����ʹ��Jackson��Gson��
 * @author leoi555
 *@date 2018��9��5��
 */
public class JsonArrayObj {
	public static void main(String[] args) {
		//json�����ĺ�����goole��
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
