<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  	<h1>我的网站-登录</h1><hr>
  	<form action="${pageContext.request.contextPath }/servlet/LoginServlet" method="POST">
  		用户名:<input type="text" name="username"/>
  		密码:<input type="password" name="password"/>
  		<input type="submit" value="登录"/>
  	</form>
  </body>
</html>
