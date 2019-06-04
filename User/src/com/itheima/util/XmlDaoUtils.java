package com.itheima.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


public class XmlDaoUtils {
	private static Document document=null;
	private XmlDaoUtils() {
		// TODO Auto-generated constructor stub
	}
	static{
		//sax解析
				SAXReader reader=new SAXReader();
				try {
					 document=reader.read(XmlDaoUtils.class.getClassLoader().getResource("users.xml").getPath());
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	}
	public static Document getDom() {
		return document;
		
	}
	//更新到xml
	public static  void refxml() {
		try {
			XMLWriter writer=new XMLWriter(new FileOutputStream(XmlDaoUtils.class.getClassLoader().getResource("user.xml").getPath()),OutputFormat.createPrettyPrint());
			writer.write(document);
			writer.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
