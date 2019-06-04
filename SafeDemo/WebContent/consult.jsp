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
		咨询模块
		<p>欢迎你</p>
		<c:if test="${sessionScope.user}!=null">
		${sessionScope.user};
		</c:if>
		<c:if test="${sessionScope.user}==null">
			<c:out value="">请登录</c:out>
		</c:if>
</body>
</html>