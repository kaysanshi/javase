package com.itheima.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

//��ȡ·��
public class Service {
	//���ַ�����ʹ�ò�����
	public void methol1() throws FileNotFoundException, IOException{
		Properties properties=new Properties();
		properties.load(new FileReader(Service.class.getClassLoader().getResource("config.properties").getPath()));
		System.out.println(properties.getProperty("username"));
		System.out.println(properties.getProperty("password"));
	}
	/*
	 * 6)����ServletContext�����ȡsrc����������ļ���ע�⣺��Դ��src���桿
 
  ServletContext context = this.getServletContext();
 
  String realpath = context.getRealPath("/WEB-INF/classes/db.properties");  
 
  //��ȡ�������ļ���   
 
  String filename = realpath.substring(realpath.lastIndexOf("\\")+1);
 
  System.out.println("��ǰ�������ļ��ǣ�" + filename); 
 
  FileInputStream in = new FileInputStream(realpath);
 
  Properties prop = new Properties();
 
  prop.load(in); 
 
  String url = prop.getProperty("url");
 
  String username = prop.getProperty("username");
 
  String password = prop.getProperty("password");
	 */
	/*
	 * /��ȡ�����ļ��ĵ�һ�ַ�ʽ��ע�⣺��Դ��WebRoot���桿
          private void test1() throws IOException { 
                ServletContext context = this.getServletContext();
                InputStream in = context.getResourceAsStream("/db.properties"); 
                Properties prop = new Properties();  //map
                prop.load(in); 
                String url = prop.getProperty("url");
                String username = prop.getProperty("username");
                String password = prop.getProperty("password"); 
                System.out.println(url);
                System.out.println(username);
                System.out.println(password);
          } 
     //��ȡ�����ļ��ĵڶ��ַ�ʽ��ע�⣺��Դ��WebRoot���桿
          private void test2() throws IOException {
                ServletContext context = this.getServletContext();
                String realpath = context.getRealPath("/db.properties");  
                //��ȡ�������ļ���   realpath=abc.properties
                String filename = realpath.substring(realpath.lastIndexOf("\\")+1);
                System.out.println("��ǰ�������ļ��ǣ�" + filename); 
                FileInputStream in = new FileInputStream(realpath);
                Properties prop = new Properties();
                prop.load(in); 
                String url = prop.getProperty("url");
                String username = prop.getProperty("username");
                String password = prop.getProperty("password"); 
                System.out.println("�ļ������������ݣ�");
                System.out.println(url);
                System.out.println(username);
                System.out.println(password); 
          }  
      //��ȡ�����ļ��ĵ����ַ�ʽ��ע�⣺��Դ��WebRoot���桿
          private void test3() throws IOException {
                ServletContext context = this.getServletContext();
                URL url = context.getResource("/resource/db.properties");
                InputStream in = url.openStream(); 
                FileInputStream in = new FileInputStream(realpath);
                Properties prop = new Properties();
                prop.load(in); 
                String url = prop.getProperty("url");
                String username = prop.getProperty("username");
                String password = prop.getProperty("password"); 
                System.out.println("�ļ������������ݣ�");
                System.out.println(url);
                System.out.println(username);
                System.out.println(password);
          }  
 
    //��ע�⣺��Դ��src���桿
       //��ȡsrc����������ļ�(��ͳ��ʽ����ȡ),
        //* ע�����·���������Java����������λ�ã����ڴ�ͳ�������������� classpath ��������Java����� ��ȡ�����·����
         * ����javaweb���򲻿��У���һ�ж����ܵ�ServletContext�Ĺ��� 
          private void test4() throws IOException {
                FileInputStream in = new FileInputStream("classes/db.properties");//���ַ�ʽ������
                System.out.println(in);
          }
          //��ȡsrc����������ļ���ע�⣺��Դ��src���桿
          private void test5() throws IOException {
                InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
                Properties prop = new Properties();  //map
                prop.load(in); 
                String url = prop.getProperty("url");
                String username = prop.getProperty("username");
                String password = prop.getProperty("password"); 
                System.out.println(url);
                System.out.println(username);
                System.out.println(password);
          } 
          public void doPost(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {
                doGet(request, response);
 
          } 
 
    }
 
 
 
 
 
 
10����web���̵���ͨjava��������ζ�ȡ��Դ�ļ�
 
    Demo������ 
 
    public class StudentDao {  //servlet 
 
          public String get() throws IOException {  //��װ������ 
 
                test1();
                test2();
                return null;
 
          }
 
     
 
          //���´����ڶ��ļ�ʱ�����Զ������º���ļ�
 
          public void test2() throws IOException{         
 
                ClassLoader loader = StudentDao.class.getClassLoader();
 
                URL url = loader.getResource("cn/itcast/dao/db.properties");//��ʱ��Ȼ����Դװ�ؽ��ڴ����ˡ�
 
                String filepath = url.getPath();//��ȡ�����·����
 
             
 
                FileInputStream in = new FileInputStream(filepath);
 
                Properties prop = new Properties();  //map
 
                prop.load(in);
 
             
 
                String dburl = prop.getProperty("url");
 
                String username = prop.getProperty("username");
 
                String password = prop.getProperty("password");
 
             
 
                System.out.println(dburl);
 
                System.out.println(username);
 
                System.out.println(password);
 
          }         
 
         
 
          //���´����ڶ��ļ�ʱ�������������º����Դ�ļ�
 
          public void test1() throws IOException{
 
                ClassLoader loader = StudentDao.class.getClassLoader();
 
                InputStream in = loader.getResourceAsStream("cn/itcast/dao/db.properties");
 
             
 
                Properties prop = new Properties();  //map
 
                prop.load(in);
 
             
 
                String url = prop.getProperty("url");
 
                String username = prop.getProperty("username");
 
                String password = prop.getProperty("password");
 
             
 
                System.out.println(url);
 
                System.out.println(username);
 
                System.out.println(password);         
 
          }     
 
      //ͨ����װ�������ļ�ʱ����Ҫע�������
 
      //��ע������Դ�ļ��ܴ�ʱ��������װ����װ��ʱ�����ܻ�����ڴ������
 
    }
 
 
 
���ص�֪ʶ��Web�����У�ʹ�á���װ��������ȡ���·������Դ�����·�����������·��classes�ļ���/src·���¡���
 
src��·���£�  servletʱ��ʹ��ServletContext�����ȡ������·����
 
             ��servletʱ��ʹ����װ����ʹ�������·���������src��
 
WebRoot�£� servletʱ��ʹ��ServletContext�����ȡ������·�����ж�ȡ��
 
            ��servletʱ���޷���ȡ��
 
 
	 */
}
