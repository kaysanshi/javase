<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>实验：遍历10到100的偶数，如果数字所在的位置是3的倍数，显示成红色</h1><hr>
  	<c:forEach begin="10" end="100" step="2" var="i" varStatus="stat">
	  	<c:if test="${stat.count % 3 == 0}">
	  		<font color="red">
	  			${i }
	  		</font>
	  	</c:if>
	  	<c:if test="${stat.count % 3 != 0}">
	  		<font color="blue">
	  			${i }
	  		</font>
	  	</c:if>
  	</c:forEach>
  
  	<h1>循环执行指定的内容若干次</h1><hr>
  	<c:forEach begin="0" end="10" step="2" var="i" >
  		${i },
  	</c:forEach>
  	
	<h1>遍历map中的数据</h1>
	<%
		Map map=new HashMap();
			map.put("1", "转给你");
			map.put("2", "转给你");
			map.put("3", "3");
			map.put("4", "到");
			pageContext.setAttribute("map", map);
	%>
	<c:forEach items="${map}" var="entry">
		${entry.key }:${entry.value}<br>
	</c:forEach>
	<h1>遍历集合中的数据</h1><hr>
  	<%
		List list = new ArrayList();
		list.add("美国");
		list.add("中国");
		list.add("俄罗斯");
		list.add("印度");
		list.add("巴西");
  		pageContext.setAttribute("list",list);
  	 %>
  	 <c:forEach items="${list}" var="c">
  	 ${c }<br>
  	 </c:forEach>	
	<h1>遍历数组中的数据</h1>
	<%
		String[] city={"上海","北京","南京","西安"};
		pageContext.setAttribute("city", city);
	%>
	<c:forEach items="${city}" var="c">
		${c}<br>
	</c:forEach>
	
</body>
</html>