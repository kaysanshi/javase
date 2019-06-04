package com.itheima;

import org.apache.commons.dbcp.BasicDataSource;

/*
 * ʹ�����ݿ�����ӳ�
 * DBCP���ӳ�1.8�Ͳ�����;
 *   BasicDataSource ʵ�� javax.sql.DataSource�ӿ�
 *   dbcp:Ӧ������jar��:commons-dbcp.jar:���ӵ�ʵ��
 *   commons-pool.jar��:commons-pool.jar:���ӳ�ʵ�ֵĿ�;
 *   ʹ��:1.����jar��;��������,��������;
 *   
 */
public class BasicDataSourceDBCP {

	public static BasicDataSource getSource(){
		//����������Դ
		BasicDataSource source = new BasicDataSource();
		//��BasicDataSource���������ñ�Ҫ����
		//������������
		source.setDriverClassName("com.mysql.jdbc.Driver");
		//�������ݿ�����URL
		source.setUrl("jdbc:mysql://localhost:3306/gjp");
		//�����û���������
		source.setUsername("root");
		source.setPassword("123");
		return source;
	}
}
