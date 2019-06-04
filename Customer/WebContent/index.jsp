<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户管理</title>
</head>
<body>
	<h2>客户管理</h2>
	<a href="${pageContext.request.contextPath}/addCustomer.jsp">添加客户</a>
	<a href="${pageContext.request.contextPath}/ListCustomerServlet">客户列表</a>
	<a href="${pageContext.request.contextPath }/PageCustomerServlet?thispage=1">分页查询客户</a>
	
</body>
</html>