<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>c:remove删除域中的属性</h1>
	<%
		pageContext.setAttribute("name", "站那个");
		request.setAttribute("name", "张三");
		session.setAttribute("name", "站那个2");
		application.setAttribute("name", "张三2");
	%>
	<c:remove var="name" scope="request"/>
	${name}
</body>
</html>