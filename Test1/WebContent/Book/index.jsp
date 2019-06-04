<%@ page pageEncoding="UTF-8" import="java.util.*" %>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理系统</title>
<link rel="stylesheet" href="css/book.css" type="text/css">
</head>
<body>
<h2 align="center">图书管理系统</h2>
<p align="center"><a href="add.html">添加图书信息</a><p>
<jsp:useBean id="book" class="beans.Book" />
<table align="center" width="50%" border="1">
	<tr><th>书名</th><th>作者</th><th>出版社</th><th>价格</th><th>管理</th></tr>
	<%
		ArrayList books = (ArrayList)book.getAllBooks();
		for(Object o : books){
			Map m = (HashMap)o;
	%>
			<tr><td><%=m.get("bookname")%></td>
			<td><%=m.get("author") %></td>
			<td><%=m.get("press") %></td>
			<td><%=m.get("price") %></td>
			<td><a href="edit.jsp?id=<%=m.get("id") %>">修改</a>&nbsp;
			<a href="del.jsp?id=<%=m.get("id") %>" onclick="return confirm('确定要删除吗？')">删除</a></td></tr>
	<%
		}
	%>
</table>
</body>
</html>