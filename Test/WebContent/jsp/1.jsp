<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	jsp页面中指令：session1="false";是session隐示对象不可创建
	自己也可以创建：	HttpSession sesion=request.getSession();
	sesion.setAttribute(name, value);
	errorPage="url";异常的界面   底层是请求转发
	一般都设置一个通用的错误页面在web.xml中配置
	<%
		int i=1/0;
	
	%>
</body>
</html>