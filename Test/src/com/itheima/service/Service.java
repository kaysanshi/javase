package com.itheima.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

//读取路径
public class Service {
	//这种方法的使用不可以
	public void methol1() throws FileNotFoundException, IOException{
		Properties properties=new Properties();
		properties.load(new FileReader(Service.class.getClassLoader().getResource("config.properties").getPath()));
		System.out.println(properties.getProperty("username"));
		System.out.println(properties.getProperty("password"));
	}
	/*
	 * 6)利用ServletContext对象读取src下面的配置文件【注意：资源在src下面】
 
  ServletContext context = this.getServletContext();
 
  String realpath = context.getRealPath("/WEB-INF/classes/db.properties");  
 
  //获取到操作文件名   
 
  String filename = realpath.substring(realpath.lastIndexOf("\\")+1);
 
  System.out.println("当前读到的文件是：" + filename); 
 
  FileInputStream in = new FileInputStream(realpath);
 
  Properties prop = new Properties();
 
  prop.load(in); 
 
  String url = prop.getProperty("url");
 
  String username = prop.getProperty("username");
 
  String password = prop.getProperty("password");
	 */
	/*
	 * /读取配置文件的第一种方式【注意：资源在WebRoot下面】
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
     //读取配置文件的第二种方式【注意：资源在WebRoot下面】
          private void test2() throws IOException {
                ServletContext context = this.getServletContext();
                String realpath = context.getRealPath("/db.properties");  
                //获取到操作文件名   realpath=abc.properties
                String filename = realpath.substring(realpath.lastIndexOf("\\")+1);
                System.out.println("当前读到的文件是：" + filename); 
                FileInputStream in = new FileInputStream(realpath);
                Properties prop = new Properties();
                prop.load(in); 
                String url = prop.getProperty("url");
                String username = prop.getProperty("username");
                String password = prop.getProperty("password"); 
                System.out.println("文件中有如下数据：");
                System.out.println(url);
                System.out.println(username);
                System.out.println(password); 
          }  
      //读取配置文件的第三种方式【注意：资源在WebRoot下面】
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
                System.out.println("文件中有如下数据：");
                System.out.println(url);
                System.out.println(username);
                System.out.println(password);
          }  
 
    //【注意：资源在src下面】
       //读取src下面的配置文件(传统方式不可取),
        //* 注：相对路径是相对于Java虚拟机的相对位置，而在传统方法中我们设置 classpath 来设置与Java虚拟机 读取程序的路径。
         * 而在javaweb中则不可行，但一切都可受到ServletContext的管理。 
          private void test4() throws IOException {
                FileInputStream in = new FileInputStream("classes/db.properties");//此种方式不可行
                System.out.println(in);
          }
          //读取src下面的配置文件【注意：资源在src下面】
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
 
 
 
 
 
 
10、在web工程的普通java程序中如何读取资源文件
 
    Demo样例： 
 
    public class StudentDao {  //servlet 
 
          public String get() throws IOException {  //类装载器读 
 
                test1();
                test2();
                return null;
 
          }
 
     
 
          //以下代码在读文件时，可以读到更新后的文件
 
          public void test2() throws IOException{         
 
                ClassLoader loader = StudentDao.class.getClassLoader();
 
                URL url = loader.getResource("cn/itcast/dao/db.properties");//此时仍然把资源装载近内存中了。
 
                String filepath = url.getPath();//获取其绝对路径。
 
             
 
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
 
         
 
          //以下代码在读文件时，读到不到更新后的资源文件
 
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
 
      //通过类装载器读文件时，需要注意的问题
 
      //备注：当资源文件很大时，采用类装载器装载时，可能会造成内存溢出。
 
    }
 
 
 
【重点知识：Web工程中，使用“类装载器”读取相对路径的资源。相对路径是相对于类路径classes文件夹/src路径下。】
 
src类路径下：  servlet时：使用ServletContext对象获取器绝对路径，
 
             非servlet时：使用类装载器使用其相对路径（相对于src）
 
WebRoot下： servlet时：使用ServletContext对象获取器绝对路径进行读取。
 
            非servlet时：无法读取。
 
 
	 */
}
