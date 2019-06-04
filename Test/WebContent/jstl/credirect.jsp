<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  	<c:redirect url="/index.jsp" context="${pageContext.request.contextPath}">
		<c:param name="name" value="zhang"></c:param>
  	</c:redirect>
  </body>
</html>
