<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- jsp中的请求转发是用于运行时服务器段结束当前页面后跳转到指定页面 -->
	<%
		String age=request.getParameter("age");
		String access=null;
		if(Integer.parseInt(age)>18){
			access="OK";
		}else{
			access="NO";
		}
	%>
	<jsp:forward page="next.jsp">
		<jsp:param value="<%=access %>" name="access"/>
	</jsp:forward>

</body>
</html>