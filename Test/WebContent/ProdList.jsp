<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//url重写
	//普通的
	//*url重写的方法一旦发现浏览器带回了任意cookie信息,
	//则认为客户端没有禁用cookie,就不会再进行重写操作
	//response.encodeURL(url);
	//重定向使用的发到location的响应头中;
	//response.encodeRedirectUrl(url);
	%>
	<%
	request.getSession();
	String url1=request.getContextPath()+"/BuyServlet?prod=电视机";
	response.encodeURL(url1);
	String url2=request.getContextPath()+"/BuyServlet?prod=冰箱";
	response.encodeURL(url2);
	String url3=request.getContextPath()+"/Payservlet";
	response.encodeURL(url3);

	
	%>
	<a href="<%=url1 %>">电视机</a>
	<a href="<%=url2%>">冰箱</a>
	<a href="<%=url3 %>">结账</a>
	
</body>
</html>