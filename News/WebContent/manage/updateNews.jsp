<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>My JSP 'addNew.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/reg.css'/>">
	<script type="text/javascript" src="<c:url value='/cal/lhgcore.js'/>"></script>
<script type="text/javascript" src="<c:url value='/cal/lhgcalendar.js'/>"></script>
  </head>
  
  <body>
  ${msg}
    <h3>修改新闻</h3>
    <form action="<c:url value='/manageNewsServlet'/>" method="post">
    <input type="hidden" value="updateNew" name="action"/>
    <input type="hidden" value="${annew.id}" name="id"/>
    <table>  
<tr><td>标题：</td><td><input type="text" name="title" value="${annew.title}"/></td></tr>
<tr><td>作者：</td><td><input type="text" name="author" value="${annew.author}"/></td></tr>
<tr><td>发布日期：</td><td><input type="text" name="publishedDate" value="${annew.publisheddate}" onclick="J.calendar.get();"/></td></tr>
<tr><td>内容：</td><td><textarea name="content" rows="5" cols="50">${annew.content}</textarea></td></tr>
<tr><td colspan="2" ><input type="submit" value="修改新闻"/></td></tr>
    
    </table>
    
    </form>
  </body>
</html>
