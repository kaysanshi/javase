<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		pageContext.setAttribute("name", "zhang", PageContext.REQUEST_SCOPE);
		request.setAttribute("name", "aaa");
		session.setAttribute("name", "小咋好");
	%>
	<%=pageContext.getAttribute("name",PageContext.REQUEST_SCOPE)%>
	<!-- 搜寻四大域的属性 -->
	<%=pageContext.findAttribute("name") %>
</body>
</html>