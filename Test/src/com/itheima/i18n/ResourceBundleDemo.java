package com.itheima.i18n;

import java.util.Locale;
import java.util.ResourceBundle;
//��ͬ����ʾ��Ϣ
public class ResourceBundleDemo {
	public static void main(String[] args) {
		//����src��properties�ļ�
		//�ڶ�ȡproperties�ļ�ʱ�����Դ���һ��Locale ʵ���������ڴ���һ���ض��ĵ������Ρ��Ļ�����
		/*
		 * ResourceBundle�ڲ��ҵ�ʱ�����Ȳ�ָ����Ȼ����ϵͳ�ģ�Ȼ����default��Ĭ�ϵ�
		 */
		ResourceBundle bundle=ResourceBundle.getBundle("resource",Locale.CHINA);
		//��ȡproperties�ļ�������
		String value=bundle.getString("username");
		System.out.println(value);
	}
}
