<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'news_list.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
body 
{     
      width:auto; margin-top:12px; 
      float:left; font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
      font-size:11px; 
      line-height:25px;
      letter-spacing:1px
}

</style>
</head>

<body>
	<c:if test="${not empty user}">
       ${user.username }，欢迎光临！
  </c:if>

	<table>
		<c:forEach var="record" items="${list}">
			<tr>
				<td>${record.title}</td>
				<td>${record.publisheddate}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
