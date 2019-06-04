<%@page import="beans.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在脚本元素中使用javaBean</title>
</head>
<body>
		<% Person bean=new Person(); %>
		属性的初始值为:<br>
		姓名：<%=bean.getName() %><br>
		年龄：<%=bean.getAge()%><br>
		性别：<%=bean.getSex() %><br>
		籍贯：<%=bean.getCity() %><br>
		职业：<%=bean.getCareer() %><br>
		<%
			bean.setName("天佑");
			bean.setAge(30);
			bean.setSex("男");
			bean.setCity("不知道");
			bean.setCareer("网红");
		
		%>
		属性的更改后的值为:<br>
		姓名：<%=bean.getName() %><br>
		年龄：<%=bean.getAge()%><br>
		性别：<%=bean.getSex() %><br>
		籍贯：<%=bean.getCity() %><br>
		职业：<%=bean.getCareer() %><br>
</body>
</html>