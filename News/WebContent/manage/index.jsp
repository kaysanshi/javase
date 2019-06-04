<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>新闻管理页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<style type="text/css">
		*{
			font-size:10pt;
		}
		body{
			text-align:center;
			margin: 0px;
		}
		.table{
			width:100%;
			height:100%;
			border:1px solid gray;/*固定边框,1像素*/
		    border-collapse: collapse;/*单线的列表边框*/
		}
		.table td{
			border:1px solid gray;/*固定边框,1像素*/
		}
		iframe {
			width: 100%;
			height: 100%;
		}
	</style>
  </head>
  
  <body>
    <table class="table" align="center">
	<tr style=" height: 120px; ">
		<td colspan="2" align="center">
			<iframe frameborder="0" src="<c:url value='/manage/top.jsp'/>" name="top"></iframe>
		</td>
	</tr>
	<tr>
		<td width="120" style="padding:5px;" align="center" valign="top">
			<iframe frameborder="0" width="80" src="<c:url value='/manage/left.jsp'/>" name="left"></iframe>
		</td>
		<td>
			<iframe frameborder="0" src="<c:url value='/manage/main.jsp'/>" name="main"></iframe>
		</td>
	</tr>
</table>
  </body>
</html>