package com.leo.test;

import java.io.StringWriter;

import org.json.JSONObject;

/**
 * json��ʹ��
 * @author leoi555
 *@date 2018��9��5��
 */
public class JsonTest {
	public static void main(String[] args) {
		/**
		 * ��map�ر�����ƣ�����Ҳ�кܴ�Ĳ�ʹ��
		 */
		JSONObject obj=new JSONObject();
		obj.put("name", "foo");
        obj.put("num", new Integer(100));
        obj.put("balance", new Double(1000.21));
        obj.put("is_vip", new Boolean(true));
        System.out.print(obj);
        System.out.println();
        //json�Ķ�����
        StringWriter out= new StringWriter();
        obj.write(out);
        String  jsonText=out.toString();
        System.out.println(jsonText);
	}
}
