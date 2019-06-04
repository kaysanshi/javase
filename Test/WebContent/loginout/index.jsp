<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  	<h1>我的网站</h1><hr>
  	<%
  		//获取session中的登录状态
		String user = (String)session.getAttribute("user");
  	 %>
  	 <%
  	 	if(user == null || "".equals(user)){//用户没有登录
  	 		%>
  	 			欢迎光临!游客!
  	 			<a href="${pageContext.request.contextPath }/loginout/login.jsp">登录</a>
  	 			<a href="#">注册</a>
  	 		<%
  	 	}else{//用户登录过
  	 		%>
  	 			欢迎回来!<%=user %>!
  	 			<a href="${pageContext.request.contextPath }/servlet/LogoutServlet">注销</a>
  	 		<%
  	 	}
  	  %>
  </body>
</html>
