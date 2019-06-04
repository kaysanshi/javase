package com.itheima.domain;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

public class Person implements Serializable,HttpSessionBindingListener,HttpSessionActivationListener{
		private String name;
		private String age;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		//��
		@Override
		public void valueBound(HttpSessionBindingEvent event) {
			// TODO Auto-generated method stub
			System.out.println("��ǰjavabean���󱻰󶨵�session����javabean�Լ���֪����");
		}
		//�Ƴ���
		@Override
		public void valueUnbound(HttpSessionBindingEvent event) {
			// TODO Auto-generated method stub
			System.out.println("��ǰjavabean�����Ƴ�session����javabean�Լ���֪���Ƴ�");

		}
		//javabean��֪���Լ�����session���ۻ���
		@Override
		public void sessionWillPassivate(HttpSessionEvent se) {
			// TODO Auto-generated method stub
			System.out.println("��ǰjavabean���󱻶ۻ���");

		}
		//javabean��֪���Լ�����session���Le
		@Override
		public void sessionDidActivate(HttpSessionEvent se) {
			// TODO Auto-generated method stub
			System.out.println("��ǰjavabean���󱻻��");

		}
}
