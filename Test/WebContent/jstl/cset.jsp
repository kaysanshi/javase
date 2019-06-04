<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.itheima.domain.Person"%>
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
	<!-- 运行出现错误 -->
	<h1>修改域中的javabean属性</h1>
	<%
		Person p=new Person();
		pageContext.setAttribute("p", p);
	%>
	<c:set target="${p}" property="name" value="张华"></c:set>
		${p.name}
	<h1>获取或修改域中的Map</h1>
		<%
			Map map=new HashMap();
			pageContext.setAttribute("map", map);
		%>
		<c:set target="${map}" property="cellphone" value="1000010"></c:set>
		<c:set target="${map}" property="cellphone" value="1022010"></c:set>
		${map.cellphone}
	<h1>设置修改域中的属性</h1>
	<c:set var="aname" value="五行" ></c:set>
	${aname}
</body>
</html>