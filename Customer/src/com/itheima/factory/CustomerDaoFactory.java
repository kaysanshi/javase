package com.itheima.factory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.itheima.dao.CustomerDao;


//���õĲ�����ֻ��dao�������δ��serivce����
public class CustomerDaoFactory {
	private static CustomerDaoFactory factory=new CustomerDaoFactory();
	//��ȡ�����ļ���
	private static Properties properties=null;
	private CustomerDaoFactory(){
		
	}
	public static CustomerDaoFactory getFactory() {
		return factory;
	}
	static{
		
		try {
			properties=new Properties();
			properties.load(new FileReader(CustomerDaoFactory.class.getClassLoader().getResource("confing.properties").getPath()));
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public CustomerDao getDao(){
		
		try {
			String clazz=properties.getProperty("CustomerDao");
			return (CustomerDao) Class.forName(clazz).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();	
		}
	}

}
