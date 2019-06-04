<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>include.jsp</title>
</head>
<body>
	<h1>动作标签的使用</h1>
	<jsp:include page="box.jsp">
	<jsp:param name="color" value="#OOFF00"/>
	<jsp:param name="title" value="this is the title"/>
	<jsp:param name="content" value="this is the content"/>
	</jsp:include>
</body>
</html>