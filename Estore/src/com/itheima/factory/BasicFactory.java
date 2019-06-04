package com.itheima.factory;

import java.io.FileReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Properties;

import com.itheima.annotation.Tran;
import com.itheima.dao.Dao;
import com.itheima.dao.OrderDao;
import com.itheima.service.Service;
import com.itheima.service.UserService;
import com.itheima.util.TransactionManager;

public class BasicFactory {
	private static BasicFactory factory = new BasicFactory();
	private static Properties prop = null;
	private BasicFactory(){}
	static{
		try {
			prop = new Properties();
			prop.load(new FileReader(BasicFactory.class.getClassLoader().getResource("config.properties").getPath()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public static BasicFactory getFactory(){
		return factory;
	}
	/**
	 * ��ȡService�ķ���
	 */
	public <T extends Service> T getService(Class<T> class1){
		try{
			//--���������ļ����������Service
			String infName = class1.getSimpleName();
			String implName = prop.getProperty(infName);
			final T service = (T) Class.forName(implName).newInstance();
			
			//--Ϊ��ʵ��AOP,����service����,����ע��ȷ����Service����ִ��֮ǰ��֮����һЩ����,����:�������/��¼��־/ϸ����Ȩ�޿���....
			@SuppressWarnings("unchecked")
			T proxyService =  (T) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces()
				 , new InvocationHandler(){
				
					//����ע���������
					public Object invoke(Object proxy, Method method,Object[] args) throws Throwable {
						
						if(method.isAnnotationPresent(Tran.class)){//�����ע��,���������:
							try{
								TransactionManager.startTran();//--��������
								
								Object obj = method.invoke(service, args);//--����ִ�з���
								
								TransactionManager.commit();//--�ύ����
								return obj;
							}catch (InvocationTargetException e) {
								TransactionManager.rollback();//--�ع�����
								throw new RuntimeException(e.getTargetException());
							} catch (Exception e) {
								TransactionManager.rollback();//--�ع�����
								throw new RuntimeException(e);
							}finally{
								TransactionManager.release();//--�ͷ���Դ
							}
						}else{//���û��ע��,�򲻹�������,ֱ��ִ�з���
							return method.invoke(service, args);
						}
					}
				 
			 });
			 
			return proxyService;
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	@SuppressWarnings("unchecked")
	public <T> T getInstance(Class<T> clazz){
		try{
		String infName = clazz.getSimpleName();
		String implName = prop.getProperty(infName);
		return (T) Class.forName(implName).newInstance();
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	/**
	 * ��ȡdao�ķ���
	 */
	public <T extends Dao> T getDao(Class<T> clazz){
		try{
			String infName = clazz.getSimpleName();
			String implName = prop.getProperty(infName);
			return (T) Class.forName(implName).newInstance();
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
