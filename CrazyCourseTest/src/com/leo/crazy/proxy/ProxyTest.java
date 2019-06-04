package com.leo.crazy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {
	  public static void main(String[] args)throws Exception {
			  // 创建一个InvocationHandler对象
		  InvocationHandler handler=new MyInvokationHandler();
		  // 使用指定的InvocationHandler来生成一个动态代理对象
		  Person p=(Person)Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, handler);          // 调用动态代理对象的walk()和sayHello()方法
			  p.walk();
			  p.sayHello("孙悟空");
		    }
}
