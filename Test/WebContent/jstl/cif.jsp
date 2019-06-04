<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- -JSTL core库的有两种taglib伪指令, 其中RT库即是依赖于JSP传统的请求时属性值, 而不是依赖于EL来实现(称为EL库.JSP2.0将支持EL)
JSP中使用<%@ taglib uri=http://java.sun.com/jstl/core prefix="c"%>在2.3版本都可以,在2.4就不行了, 难道是版本不兼容吗?
只要将
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
改为
<%@ taglib uri=http://java.sun.com/jstl/core_rt prefix="c"%> -->
	<h1>cif</h1>
	<c:if test="${2>1}">
		${1}
	</c:if>
	<c:if test="${2<1}">
		2>1是不可能的
	</c:if>
</body>
</html>