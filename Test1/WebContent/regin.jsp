<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<h2>你的个人信息如下：</h2>
	<%request.setCharacterEncoding("UTF-8"); %><br/>
	你的姓名是：<%=request.getParameter("name") %><br/>
	你的密码是：<%=request.getParameter("pw") %><br/>
	你的职业是：<%=request.getParameter("career") %><br/>
	你的电话号码是：<%=request.getParameter("telephone") %><br/>
	你的电子邮箱是：<%=request.getParameter("email") %><br/>
	<% 
		String[] fav=request.getParameterValues("fav")	;
		if(fav!=null){
			out.print("你的兴趣爱好：");
			for(String f:fav){
				out.print(f);
			}
			out.print("<br/>");
		}
	%>
	你的自我简介是：<%=request.getParameter("intro") %>
</body>
</html>