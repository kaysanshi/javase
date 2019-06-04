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
//dom4j��ɾ��
public class Dom4jTest2 {
	//����;
	public void find(){
		try {
			SAXReader reader=new SAXReader();
			Document dom=reader.read("book.xml");
			Element root=dom.getRootElement();
			
			List<Element> list=root.elements();
			Element book2Ele=list.get(1);
			System.out.println(book2Ele.element("����").getText());
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//����
	public void  add(){
		try {
			SAXReader reader=new SAXReader();
			Document dom = reader.read("book.xml");
			Element root=dom.getRootElement();
			//1.�ȴ�����Ҫ���ӵĽڵ�
			Element price2Ele=DocumentHelper.createElement("�ؼ�");
				price2Ele.setText("40Ԫ");
			//2.��ȡ���ڵ�Ȼ��Ѽ���ĸ�����ȥ
				Element bookEle=root.element("��");
				bookEle.add(price2Ele);
			//���ڴ��dom����д��xml�ļ����ض�ʹ��xml�е����ݽ��и���
				FileWriter writer=new FileWriter("book.xml");
				dom.write(writer);
				writer.flush();
				writer.close();
//			��ʽ����ʽд��;
//			XMLWriter writer=new XMLWriter(new FileWriter("book.html"), OutputFormat.createPrettyPrint());
//					writer.write(dom);
//					writer.close();
		} catch (DocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//����
	public void update(){
		try {
			SAXReader reader=new SAXReader();
			Document dom = reader.read("book.xml");
			Element root=dom.getRootElement();
			root.element("��").element("�ؼ�").setText("10Ԫ");
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
	//ɾ��
	public void delete(){
		try {
			SAXReader reader=new SAXReader();
			Document dom = reader.read("book.xml");
			Element root=dom.getRootElement();
			
			Element price=root.element("��").element("�ؼ�");
			//ͨ���ҵ����ڵ�Ȼ����ӽڵ���Ƴ�;
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
	//��������
	public void attr(){
		try {
			SAXReader reader=new SAXReader();
			Document dom = reader.read("book.xml");
			Element root=dom.getRootElement();
			Element bookEle=root.element("��");
			bookEle.addAttribute("������", "�������Ա");
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
