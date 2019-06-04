<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.itheima.com/MyTag" prefix="MyTag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看ip的方式</title>
</head>
<body>
	java输出的ip:<%=request.getRemoteAddr()%>
	<br>
	标签输出的ip:<MyTag:showip></MyTag:showip>
</body>
</html>