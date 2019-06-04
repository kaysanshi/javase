package com.leo.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.domain.Address;
import com.leo.domain.Person;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/xml;charset=utf-8");   
        response.setHeader("Cache-Control","no-cache");   
           
        try{   
              
            Person person1 = new Person();   
           person1.setName("С��");  
           person1.setSex("Ů");   
           person1.setAge(23);   
            person1.setAddress(new Address("����ʡ","������","����԰��"));   
              
           List<Person> list = new ArrayList<Person>();   
           list.add(person1);   
              
            try{   
               //��listת��ΪJsonArray����
               JSONArray jsonArray = JSONArray.fromObject(list);   
               //�൱��map����
               JSONObject jsonObject = new JSONObject();   
               //������װ��������   
               jsonObject.put("person", jsonArray);   
                  
               response.getWriter().write(jsonObject.toString());    
                  
            } catch(IOException e) {   
               e.printStackTrace();   
           }   
              
        }catch(Exception e){   
           e.printStackTrace();   
        }     
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
