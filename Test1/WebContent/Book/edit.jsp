<%@ page pageEncoding="UTF-8" import="java.util.HashMap" %>
<html>
<head>
<title>修改图书信息</title>
<link rel="stylesheet" href="css/book.css" type="text/css">
<script type="text/javascript" src="js/book.js"></script>
</head>
<body>
<jsp:useBean id="book" class="beans.Book" />
<jsp:setProperty name="book" property="id" />
<%
	HashMap bookinfo = (HashMap)book.getBook();
	if(bookinfo != null){
%>
		<h2 align="center">修改图书信息</h2>
		<form name="form1" onSubmit="return check()" action="edit_do.jsp" method="post">
		<input type="hidden" name="id" value="<%=bookinfo.get("id") %>">
		<table align="center" width="30%" border="1">
			<tr><th width="30%">书名：</th>
				<td><input type="text" name="bookname" value="<%=bookinfo.get("bookname") %>"></td></tr>
			<tr><th>作者：</th>
				<td><input type="text" name="author" value="<%=bookinfo.get("author") %>"></td></tr>
			<tr><th>出版社：</th>
				<td><input type="text" name="press" value="<%=bookinfo.get("press") %>"></td></tr>
			<tr><th>价格：</th>
				<td><input type="text" name="price" value="<%=bookinfo.get("price") %>"></td></tr>
			<tr><th colspan="2">
			  <input type="submit" value="修改">
			  <input type="reset" value="重置"></th></tr>
		</table>
		</form>
<%
	}
%>
</body>
</html>