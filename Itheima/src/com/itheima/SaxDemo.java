package com.itheima;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

//sax������ ʹ��
public class SaxDemo {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//1.��ȡ�������Ĺ���
		SAXParserFactory factory=SAXParserFactory.newInstance();
		//2.ͨ��������ȡsax����������SAXParser����ʵ��
		SAXParser parser=factory.newSAXParser();
		//3.��ȡ��ȡ��
		XMLReader reader=parser.getXMLReader();
		//4.ע���¼�������,��sax����������һ��ʵ��;
		//����Ԫ�ص����ݣ��ַ����ݣ�����ָ���/����Ԫ�أ�����˳����ʾ��startElement�¼�����Ӧ��endElement�¼�֮��
		reader.setContentHandler( new MyContentHandel2());
		//5.����xml
		reader.parse("book.xml");
	}

}
//���������ģʽ;
class MyContentHandel2 extends DefaultHandler{
	private String eleName=null;
	//��ʼԪ��;
	@Override
	public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)
			throws SAXException {
		// TODO Auto-generated method stub
		this.eleName=qName;
	}
	//������Ԫ��
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		eleName=null;
	}
	//�����ַ���֪ͨ;
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		if("����".equals(eleName)){
			System.out.println(new String(ch,start,length));
		}
	}
	
}
//����ʵ���˽ӿڵ���Ϊ����ʾ�����ĵ��߼����ݵ�֪ͨ;
class MyContentHandel implements ContentHandler{
//����Ԫ�ؿ�ͷ��֪ͨ��
@Override
public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes atts) throws SAXException {
	// TODO Auto-generated method stub
	System.out.println("�����˿�ʼ��ǩ"+qName);
}
//����Ԫ�ؽ�β��֪ͨ
	@Override
	public void endElement(String url, String localName, String qname) {
		// TODO Auto-generated method stub
		System.out.println("���ֽ�����ǩ:"+qname);
	}
//�����ַ�����֪ͨ�� 
	@Override
	public void characters(char[] ch, int start, int length) {
		// TODO Auto-generated method stub
		System.out.println(new String(ch, start, length));
	}
//�����ļ�������֪ͨ�� 
	@Override
	public void endDocument() {
		// TODO Auto-generated method stub
		
	}

//����ǰ׺URIӳ��ķ�Χ��
	@Override
	public void endPrefixMapping(String prefix) {
		// TODO Auto-generated method stub
		
	}
//��Ԫ�������н��յ��ɺ��ԵĿհ׵�֪ͨ�� 
	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) {
		// TODO Auto-generated method stub
		
	}
//���մ���ָ���֪ͨ��
	@Override
	public void processingInstruction(String target, String data) {
		// TODO Auto-generated method stub
		
	}
//��������ʵ���֪ͨ�� 
	@Override
	public void skippedEntity(String name) {
		// TODO Auto-generated method stub
		
	}
//�����ļ���ͷ��֪ͨ�� 
	@Override
	public void startDocument() {
		// TODO Auto-generated method stub
		System.out.println("�����ļ���ͷ");
	}
 
	
//��ʼһ��prefix-URI�����ռ�ӳ��ķ�Χ��
	@Override
	public void startPrefixMapping(String prefix, String url) {
		// TODO Auto-generated method stub
		
	}
//����һ������SAX�ĵ��¼�����Դ�Ķ��� 
@Override
public void setDocumentLocator(org.xml.sax.Locator locator) {
	// TODO Auto-generated method stub
	
}

	
}
