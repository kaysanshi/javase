<%@page import="com.sun.xml.internal.messaging.saaj.packaging.mime.Header"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%request.getRequestDispatcher("/include/head.jsp").include(request, response);%><br/>
		<!-- 在jsp需要数据输出时用out输出而不用response.getWriter(); -->
		<%=out.print("") %>
		body体<br/>
	
	<%request.getRequestDispatcher("/include/foot.jsp").include(request, response) ;%>

</body>
</html> 