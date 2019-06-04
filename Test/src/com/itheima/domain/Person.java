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
		//绑定
		@Override
		public void valueBound(HttpSessionBindingEvent event) {
			// TODO Auto-generated method stub
			System.out.println("当前javabean对象被绑定到session域中javabean自己感知到绑定");
		}
		//移除绑定
		@Override
		public void valueUnbound(HttpSessionBindingEvent event) {
			// TODO Auto-generated method stub
			System.out.println("当前javabean对象被移除session域中javabean自己感知到移除");

		}
		//javabean感知到自己随着session被钝化了
		@Override
		public void sessionWillPassivate(HttpSessionEvent se) {
			// TODO Auto-generated method stub
			System.out.println("当前javabean对象被钝化了");

		}
		//javabean感知到自己随着session被活化Le
		@Override
		public void sessionDidActivate(HttpSessionEvent se) {
			// TODO Auto-generated method stub
			System.out.println("当前javabean对象被活化了");

		}
}
