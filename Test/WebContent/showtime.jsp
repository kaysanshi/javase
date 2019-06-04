<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 多个组合的脚本片段 -->
	<% int a=1;%>
	<% for (int i=0;i<=5;i++){
		a++;
		
	} %>
	<% out.println(a+"");%>
	<br/>
	<font color="red">
	<% 
		Date date=new Date();
		String dates=date.toLocaleString();
		out.write("当前时间："+dates);
	%>
	</font>
	<%! int i=0;%><!-- jsp声明片段 -->
	<%! public void method1(){} %>
	<%! static{} %>
	<%! {} %><!-- 构造代码块 -->
	<%! class someclass{} %><!-- 内部类 -->
	<br/>
	<%--类变量。和变量 --%>
	<%-- 加！的为类变量   servlet 在程序中只有一个实例--%>
	<%! int a1=0; %><%--类变量 --%>
	<% int b=0; %><%-- 变量--%>
	<% 
		a1++;
		b++;
	%>
	<% out.println(a1);
		out.print(b);
	%>
</body>
</html>