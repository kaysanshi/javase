<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
	//向session域中保存一个包含三个元素的List集合对象;
		List<String> list=new ArrayList();
		list.add("滨港");
		list.add("西港");
		list.add("东港");
		list.add("南港");
		session.setAttribute("goodslist",list);
	%>
	<%
		List<String > list1=(List<String >)session.getAttribute("goodslist");
		//通过循环和El输出List集合的内容;
		for(int i=0;i<list1.size();i++){
			request.setAttribute("requestl", i);
		
	%>
	${requestl }: ${goodslist[requestl] }<br>
	<%
		}
	%>
</body>
</html>