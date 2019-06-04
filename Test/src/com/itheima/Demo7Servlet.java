package com.itheima;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo7Servlet
 */
//读取资源文件
@WebServlet("/Demo7Servlet")
public class Demo7Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Demo7Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//如果下面的写法会到当前启动的目录照这个地址;但是可以用绝对路径去寻找但是发布的时候会有错误
		//所以相对路径绝对路径都不行;
//		File file=new File("config.properties");
//		System.out.println(file.getAbsolutePath());
		///所以用以下的方法来写
		//在myeclipes可以这样用但是在eclipes中却不能这样???
		//eclipes中用这种放法;
		Properties prop=new Properties();
		prop.load((this.getServletContext().getResourceAsStream("/WEB-INF/config.properties")));
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
