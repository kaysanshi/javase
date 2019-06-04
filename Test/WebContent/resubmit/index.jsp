<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript">
  		var isNotSub = true;
  		function canSub(){
  			if(isNotSub){
  				isNotSub = false;
  				return true;
  			}else{
  				alert("请不要重复提交!!!");
  				return false;
  			}
  		}
  	</script>                                 
  </head>
  <body>
  <%
  	Random r = new Random();
  	int valinum = r.nextInt();
  	session.setAttribute("valinum",valinum+"");
   %>
  	<form action="${pageContext.request.contextPath }/servlet/ResubServlet" method="POST" onsubmit="return canSub()">
  		用户名:<input type="text" name="username"/>
  		<input type="hidden" name="valinum" value="<%=valinum %>"/>
  		<input type="submit" value="注册"/>
  	</form>
  </body>
</html>
