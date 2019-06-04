<%@page import="java.util.Vector"%>
<%@page import="com.mingribook.UserInforTrace"%>
<%@page import="com.mingribook.UserInforList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>监听</title>
</head>
<body>
		<%
		UserInforList list=UserInforList.getInstance();
		UserInforTrace ut=new UserInforTrace();
		String name=request.getParameter("name");
		ut.setUser(name);
		session.setAttribute("list", ut);
		list.addUserInfo(ut.getUser());
		session.setMaxInactiveInterval(10);
		
		
		%>
		<textarea rows="8" cols="20">
		<%
		Vector vector=list.getList();
		if(vector!=null && vector.size()>0){
			for(int i=0;i<vector.size();i++){
				out.println(vector.elementAt(i));
			}
		}
		
		%>
		
		
		
		</textarea>
</body>
</html>