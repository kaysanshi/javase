<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>利用java方式</h1>
	<%
	//浏览器的语言
		 Locale local=request.getLocale();
	ResourceBundle bundle=ResourceBundle.getBundle("resource",local);
	%>
	<form action="#" method="post">
		<%=bundle.getString("username") %>：<input type="text">
		<%=bundle.getString("password") %>：<input type="password">
		<input type="submit" value="<%=bundle.getString("submit") %>"> 
	</form>
	<h1>利用标签方式</h1>
	<fmt:setBundle basename="resource" var="bundle" scope="page"/>
	
	<form action="#" method="post">
		<fmt:message bundle="${bundle }" key="username"/>：<input type="text">
		<fmt:message bundle="${bundle }" key="password"/>：<input type="password">
		<input type="submit" value="<fmt:message bundle="${bundle }" key="submit"/>"/> 
	</form>
</body>
</html>