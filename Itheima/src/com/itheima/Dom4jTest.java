package com.itheima;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

//��Dom4j������xml����ʾ
//��Ҫ����һЩ��;
public class Dom4jTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//1.��ȡ������
			SAXReader reader=new SAXReader();
		//2.����xml��ȡ���������ĵ���dom����;
			Document document=reader.read("book.xml");
			//3.��ȡ���ڵ�
			Element root=document.getRootElement();
			//4.��ȡ��������
			String bookName=root.element("��").element("����").getText();
			System.err.println(bookName);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
