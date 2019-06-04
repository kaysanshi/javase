<%@page import="com.itheima.domain.Person"%>
<%@page import="java.util.*"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itheima.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL表达式</title>
</head>
<body>
	<h1>获取javabean</h1>
	<%
		Person p=new Person();
		p.setName("00");
		p.setAge("12");
		pageContext.setAttribute("p", p);
	
	%>
	${p.name}
	${p.age}
	<img src="${pageContent.request.contextPath }1.jpg"/>
	
	
	
	<h1>获取map中的数据</h1>
	<%
		Map<String,String> map=new HashMap();
		map.put("name1", "zhang");
		map.put("name2", "zhang1");
		map.put("name3", "zhang2");
		map.put("name4", "zhang3");
		pageContext.setAttribute("map", map);
	%>
	${map["name1"]} ${map.name2}
	<h1>获取集合中的数据</h1>
	<%
		List<String> list=new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		pageContext.setAttribute("list", list);
	%>
	${list[2]}
	<h1>获取数组中的数据</h1>
	<%
		String[] names={"小李","校长","只能够三"};
		pageContext.setAttribute("names", names);
	
	%>
	${names[2]}
	<h1>获取常量数据</h1>
	<% 
		String name="只能够";
		pageContext.setAttribute("name", name);
		
	%>
	获得变量名：${name}
	${"常量"} ${123454} ${true}

</body>
</html>