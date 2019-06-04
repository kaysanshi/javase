<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  	<h1>用户列表</h1><hr>
  	<c:forEach items="${applicationScope.usermap}" var="entry">
  		${entry.key.name }
		<c:if test="${sessionScope.user.role=='admin'}">
			<a href="${pageContext.request.contextPath }/KickServlet?id=${entry.key.id }">去死吧...</a>
		</c:if>
		<br>
  	</c:forEach>
  </body>
</html>
