package com.zcib.factory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import sun.security.jca.GetInstance;
/**
 * 工厂类
 * @author 555
 *
 */
public class BasicFactory {
	private static BasicFactory factory=new BasicFactory();
	//获取参数
	private static Properties properties=null;
	private BasicFactory(){
		
	}
	public static BasicFactory getFactory() {
		return factory;
	}
	static{
		
		try {
			properties=new Properties();
			properties.load(new FileReader(BasicFactory.class.getClassLoader().getResource("config.properties").getPath()));
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	@SuppressWarnings("unchecked")
	public <T> T GetInstance(Class<T> clazz){
		
		try {
			String cName=clazz.getSimpleName();
			String cImplName=properties.getProperty(cName);
			return (T) Class.forName(cImplName).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("服务器异常");
		}
		
	}

}
