<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  <%
  	String url = response.encodeURL(request.getContextPath()+"/index.jsp");
   %>
  	<a href="<%= url %>">hhhh</a>
  	
  	<c:url value="/index.jsp" context="${pageContext.request.contextPath}" var="url" scope="page"></c:url>
  	<a href="${url }">xxx</a>
  	
  </body>
</html>
