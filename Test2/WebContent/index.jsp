<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  	<h1>用户踢人案例</h1><hr>
  	<c:if test="${sessionScope.user == null}">
  		游客!
  		<a href="${pageContext.request.contextPath }/login.jsp">登录</a>
  	</c:if>
  	<c:if test="${sessionScope.user != null}">
  		欢迎回来,${sessionScope.user.name }
  		<a href="${pageContext.request.contextPath }/LogoutServlet">注销</a>
  		<a href="${pageContext.request.contextPath }/userList.jsp">用户列表</a>
  	</c:if>
  </body>
</html>
