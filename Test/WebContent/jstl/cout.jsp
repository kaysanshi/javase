<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>输出转义字符控制是否转义</h1>
	<a href="#">xxxx</a>
	<c:out value="<a href='#'>xxx</a>" escapeXml="true"></c:out>
	<h1>输出默认值</h1>
	<%
		String addr="西二旗";	
	%>
	<c:out value="${addr}" default="北京"></c:out>
	${addr==null? "北疆":addr }
	<h1>输出变量</h1>
	<%
		String name="张无双";
	pageContext.setAttribute("name", name);
	%>
	<c:out value="${name}"></c:out>
	${name}
	<h1>输出常量</h1>
	<c:out value="常量"></c:out>
</body>
</html>