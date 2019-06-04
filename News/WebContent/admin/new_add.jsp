<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加新闻</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="./css/reg.css">	
	
  </head>
  
  <body>
    <h3>添加新闻</h3>
    <table>
    	<tr><td>标题：</td><td><input type="text" name="title"/></td></tr>
    	<tr><td>作者：</td><td><input type="text" name="author"/></td></tr>
    	<tr><td>内容：</td><td><textarea rows="8" cols="50" name="content"></textarea></td></tr>
    	<tr><td colspan="2"><input type="submit" value="添加"/></td></tr>
    </table>
  </body>
</html>
