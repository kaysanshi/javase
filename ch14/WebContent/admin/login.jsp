<%@ page pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/header.jsp" %>
<script>
   function check(){
      username=document.f.username.value;
      password=document.f.password.value;
      if(username==""){
         alert("用户名不能为空！");
         return false;
      }else if(password==""){
         alert("密码不能为空！");
         return false;
      }else{
         return true;
      }
   }
</script>
<c:if test="${!empty login && login=='ok'}">
    <c:redirect url="/as/list"/>
</c:if>
<center>
	<h2>
		管理员登录
	</h2>
	<form method="post" action="${pageContext.request.contextPath}/ls" name="f" onSubmit="return check()">
	<table border bordercolor="#0066FF">
	<tr>
		<td align="right">用户名</td><td><input type="text" name="username"></td>
	</tr>
	<tr>
	    <td align="right">密码</td><td><input type="password" name="password"></td>
	</tr>
	<tr>
	    <td align="center" colspan="2">
	    <input type="submit" value="登录">
	    </td>
	</tr>	
	</table>
	</form>
	<c:if test="${!empty param.error && param.error=='yes'}">
	  <hr>
	  用户名或密码不正确！
	</c:if>
</center>