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
	<h1>Estore</h1>
	<c:if test="${sessionScope.user==null }">
	欢迎光临游客
	<a href="${pageContext.request.contextPath }/regist.jsp">注册</a>
	<a href="${pageContext.request.contextPath }/login.jsp">登录</a>
	</c:if>
	<c:if test="${sessionScope.user !=null }">
	欢迎回来：${sessionScope.user.username}
	<a href="${pageContext.request.contextPath }/LogoutServlet">注销</a>
	</c:if>
</body>
</html>