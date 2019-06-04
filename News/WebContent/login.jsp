<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
		function check(){
			var name = document.getElementById("username");
			var pwd = document.getElementById("password");
			var verifyCode = document.getElementById("verifyCode");
			if(!name.value ){
				alert("用户名不能为空！");
				name.focus();
				return;
			}
			if(!pwd.value)
			{
				alert("密码不能为空！");
				pwd.focus();
				return;
			}
			if(!verifyCode.value)
			{
				alert("验证码不能为空！");
				pwd.focus();
				return;
			}
			return document.getElementById("form1").submit();
		}
		function change(img){
			
			img.src = img.src+"?time="+new Date().getTime();
		}
	</script>
  </head>
  
  <body>
    	<form action="<c:url value='/userServlet'/>" method="post" id="form1" >
    	<input type="hidden" name="action" value="login"/>
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username" id="username" name="username" />
				</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password" id="password"  name="password"/>
				</td>
			</tr>
			<tr>
				<td>验证码：</td>
				<td><input type="text" name="verifyCode" id="verifyCode"  name="verifyCode"/></td>
				<td><img src="${pageContext.request.contextPath}/VerifyCodeServlet"  onclick="change(this)" title="看不清，换一张"/>
				<%
				if(request.getAttribute("verifyCodeError")!=null){ %>
				<%=request.getAttribute("verifyCodeError") %>
				<%} %>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="登录"  onclick="check()"/>
				</td>
			</tr>
		</table>
	</form>
  </body>
</html>
