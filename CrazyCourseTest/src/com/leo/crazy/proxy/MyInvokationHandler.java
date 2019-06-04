package com.leo.crazy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * 
 * @author leoi555
 *@date 2018��10��20��
 */
public class MyInvokationHandler implements InvocationHandler{
	 /*
	  ִ�ж�̬�����������з���ʱ�����ᱻ�滻��ִ�����µ�invoke����
	  ���У�
	  proxy������̬�������
	  method����������ִ�еķ���
	  args���������Ŀ�귽��ʱ�����ʵ��
	  */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("----����ִ�еķ���:" + method);
		if(args !=null){
				System.out.println("������ִ�и÷���ʱ�����ʵ��Ϊ��");
				for (Object val : args){
				      System.out.println(val);
				}
			  }else{
				System.out.println("���ø÷���û��ʵ�Σ�");}
			  return null;
			}
}
