<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML>
<html>
<head>
<title>查看新闻列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/table.css'/>" />


</head>

<body>
	<div class="table_div">
		<div class="table_content">
		<form action="<c:url value='/manageNewsServlet'/>" method="post">
			<table>
				<thead>

					<tr>
						<th width="20%">编号</th>
						<th width="20%">标题</th>
						<th width="20%">作者</th>
						<th width="20%">发布时间</th>
						<th width="20%" style="border-right:none">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="n">
						<tr>
							<td width="20%">
							<input type="checkbox" name="sel" value="${n.id}"/>
							${n.id}</td>
							<td width="20%">${n.title}</td>
							<td width="20%">${n.author}</td>
							<td width="20%">${n.publisheddate}</td>
							<td width="20%" style="border-right:none"><img width='16'
								height='16' src="<c:url value='/images/del.gif'/>"
								style="vertical-align:middle" /> <a
								href="<c:url value='/manageNewsServlet?action=updatebefore&id=${n.id}'/>">修改</a>&nbsp; <img
								width='16' height='16' src="<c:url value='/images/edt.gif'/>"
								style="vertical-align:middle" /> 
								<a href="javascript:if(confirm('确定要删除吗？')) location='<c:url value="/manageNewsServlet?action=delete&id=${n.id}"/>'">删除</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<input type="hidden" value="deleteMore" name="action"/>
			<input type="submit" value="批量删除"/>
			</form>
		</div>
	</div>
</body>
</html>