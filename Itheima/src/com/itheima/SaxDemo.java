package com.itheima;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

//sax解析的 使用
public class SaxDemo {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//1.获取解析器的工厂
		SAXParserFactory factory=SAXParserFactory.newInstance();
		//2.通过工厂获取sax解析器创建SAXParser的新实例
		SAXParser parser=factory.newSAXParser();
		//3.获取读取器
		XMLReader reader=parser.getXMLReader();
		//4.注册事件处理器,向sax解析器创建一个实例;
		//所有元素的内容（字符数据，处理指令和/或子元素）将按顺序显示在startElement事件和相应的endElement事件之间
		reader.setContentHandler( new MyContentHandel2());
		//5.解析xml
		reader.parse("book.xml");
	}

}
//适配器设计模式;
class MyContentHandel2 extends DefaultHandler{
	private String eleName=null;
	//开始元素;
	@Override
	public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)
			throws SAXException {
		// TODO Auto-generated method stub
		this.eleName=qName;
	}
	//结束的元素
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		eleName=null;
	}
	//接收字符的通知;
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		if("书名".equals(eleName)){
			System.out.println(new String(ch,start,length));
		}
	}
	
}
//这是实现了接口的类为了显示接收文档逻辑内容的通知;
class MyContentHandel implements ContentHandler{
//接收元素开头的通知。
@Override
public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes atts) throws SAXException {
	// TODO Auto-generated method stub
	System.out.println("发现了开始标签"+qName);
}
//接收元素结尾的通知
	@Override
	public void endElement(String url, String localName, String qname) {
		// TODO Auto-generated method stub
		System.out.println("发现结束标签:"+qname);
	}
//接收字符数据通知。 
	@Override
	public void characters(char[] ch, int start, int length) {
		// TODO Auto-generated method stub
		System.out.println(new String(ch, start, length));
	}
//接收文件结束的通知。 
	@Override
	public void endDocument() {
		// TODO Auto-generated method stub
		
	}

//结束前缀URI映射的范围。
	@Override
	public void endPrefixMapping(String prefix) {
		// TODO Auto-generated method stub
		
	}
//在元素内容中接收到可忽略的空白的通知。 
	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) {
		// TODO Auto-generated method stub
		
	}
//接收处理指令的通知。
	@Override
	public void processingInstruction(String target, String data) {
		// TODO Auto-generated method stub
		
	}
//接收跳过实体的通知。 
	@Override
	public void skippedEntity(String name) {
		// TODO Auto-generated method stub
		
	}
//接收文件开头的通知。 
	@Override
	public void startDocument() {
		// TODO Auto-generated method stub
		System.out.println("接收文件开头");
	}
 
	
//开始一个prefix-URI命名空间映射的范围。
	@Override
	public void startPrefixMapping(String prefix, String url) {
		// TODO Auto-generated method stub
		
	}
//接收一个查找SAX文档事件的起源的对象。 
@Override
public void setDocumentLocator(org.xml.sax.Locator locator) {
	// TODO Auto-generated method stub
	
}

	
}
