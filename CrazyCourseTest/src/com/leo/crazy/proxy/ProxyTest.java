package com.leo.crazy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {
	  public static void main(String[] args)throws Exception {
			  // ����һ��InvocationHandler����
		  InvocationHandler handler=new MyInvokationHandler();
		  // ʹ��ָ����InvocationHandler������һ����̬�������
		  Person p=(Person)Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, handler);          // ���ö�̬��������walk()��sayHello()����
			  p.walk();
			  p.sayHello("�����");
		    }
}
