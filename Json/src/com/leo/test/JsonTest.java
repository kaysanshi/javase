package com.leo.test;

import java.io.StringWriter;

import org.json.JSONObject;

/**
 * json的使用
 * @author leoi555
 *@date 2018年9月5日
 */
public class JsonTest {
	public static void main(String[] args) {
		/**
		 * 与map特别的相似，但是也有很大的不痛点
		 */
		JSONObject obj=new JSONObject();
		obj.put("name", "foo");
        obj.put("num", new Integer(100));
        obj.put("balance", new Double(1000.21));
        obj.put("is_vip", new Boolean(true));
        System.out.print(obj);
        System.out.println();
        //json的对象流
        StringWriter out= new StringWriter();
        obj.write(out);
        String  jsonText=out.toString();
        System.out.println(jsonText);
	}
}
