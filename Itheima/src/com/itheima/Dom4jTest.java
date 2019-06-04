package com.itheima;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

//用Dom4j来解析xml的演示
//需要导入一些包;
public class Dom4jTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//1.获取解析器
			SAXReader reader=new SAXReader();
		//2.解析xml获取代表整个文档的dom对象;
			Document document=reader.read("book.xml");
			//3.获取根节点
			Element root=document.getRootElement();
			//4.获取书名解析
			String bookName=root.element("书").element("书名").getText();
			System.err.println(bookName);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
