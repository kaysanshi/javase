<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>menu</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/link.css'/>">
	<base target="main" />
	
</head>
<body>
	<a href="<c:url value='/manageNewsServlet?action=findAll'/>">新闻列表</a><br/><br/>
	<a href="addNews.jsp">新闻添加</a><br/><br/>
	<a href="<c:url value='/login.jsp'/>" target="_parent">退出</a>
</body>
</html>