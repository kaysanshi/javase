<%@ page pageEncoding="UTF-8" %>
<%
	response.setContentType("text/html;charset=utf-8");
%>
<jsp:useBean id="book" class="beans.Book"/>
<jsp:setProperty name="book" property="*"/>
<%
	int result = book.addBook();
	String msg = "添加失败，点击确定跳转到图书列表页！";
	if(result == 1){
		msg = "添加成功，点击确定跳转到图书列表页！";
	}
%>
<script>window.alert('<%=msg %>');</script>
<%
	response.setHeader("Refresh", "1;url=index.jsp");
%>