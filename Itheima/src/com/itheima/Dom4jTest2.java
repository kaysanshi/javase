package com.itheima;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
//dom4j增删改
public class Dom4jTest2 {
	//查找;
	public void find(){
		try {
			SAXReader reader=new SAXReader();
			Document dom=reader.read("book.xml");
			Element root=dom.getRootElement();
			
			List<Element> list=root.elements();
			Element book2Ele=list.get(1);
			System.out.println(book2Ele.element("书名").getText());
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//增加
	public void  add(){
		try {
			SAXReader reader=new SAXReader();
			Document dom = reader.read("book.xml");
			Element root=dom.getRootElement();
			//1.先创建出要增加的节点
			Element price2Ele=DocumentHelper.createElement("特价");
				price2Ele.setText("40元");
			//2.获取父节点然后把加入的给挂上去
				Element bookEle=root.element("书");
				bookEle.add(price2Ele);
			//将内存的dom树会写到xml文件中重而使得xml中的数据进行更新
				FileWriter writer=new FileWriter("book.xml");
				dom.write(writer);
				writer.flush();
				writer.close();
//			格式化方式写入;
//			XMLWriter writer=new XMLWriter(new FileWriter("book.html"), OutputFormat.createPrettyPrint());
//					writer.write(dom);
//					writer.close();
		} catch (DocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//更新
	public void update(){
		try {
			SAXReader reader=new SAXReader();
			Document dom = reader.read("book.xml");
			Element root=dom.getRootElement();
			root.element("书").element("特价").setText("10元");
			XMLWriter writer=new XMLWriter(new FileOutputStream("book.xml"),OutputFormat.createPrettyPrint());
			writer.write(dom);
			writer.close();
		} catch (DocumentException | UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//删除
	public void delete(){
		try {
			SAXReader reader=new SAXReader();
			Document dom = reader.read("book.xml");
			Element root=dom.getRootElement();
			
			Element price=root.element("书").element("特价");
			//通过找到父节点然后把子节点给移除;
			price.getParent().remove(price);
			XMLWriter writer=new XMLWriter(new FileOutputStream("book.xml"),OutputFormat.createPrettyPrint());
			writer.write(dom);
			writer.close();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	//增加属性
	public void attr(){
		try {
			SAXReader reader=new SAXReader();
			Document dom = reader.read("book.xml");
			Element root=dom.getRootElement();
			Element bookEle=root.element("书");
			bookEle.addAttribute("出版社", "黑马程序员");
			XMLWriter writer=new XMLWriter(new FileOutputStream("book.xml"),OutputFormat.createPrettyPrint());
			writer.write(dom);
			writer.close();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public static void main(String[] args) {
		Dom4jTest2 dom4jTest2=new Dom4jTest2();
		dom4jTest2.find();
		dom4jTest2.add();
		dom4jTest2.update();
		//dom4jTest2.delete();
		//dom4jTest2.attr();
	}
}
