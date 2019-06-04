<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户信息</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/UpdateUserServlet" method="post">
	<input type="hidden" name="userid" value="${user.userid }"/>
	<table>
		<tr>
			<td>用户姓名</td>
			<td><input type="text" name="username" value="${user.username}" readonly="readonly"/></td>
		</tr>
		<tr>
			<td>用户名</td>
			<td><input type="text" name="nickname" value="${user.nickname}" readonly="readonly"/></td>
		</tr>
		<tr>
			<td>客户性别</td>
			<td><input type="radio" name="gender" value="男"
			<c:if test="${customer.gender=='男' }">checked='checked'</c:if>
			/>男
			<input type="radio" name="gender" value="女"
			<c:if test="${customer.gender=='女' }">checked='checked'</c:if>
			/>女
			</td>
		</tr>
		<tr>
			<td>学号</td>
			<td><input type="text" name="stunumber" value="${user.stunumber }"/></td>
		</tr>
		<tr>
			<td>手机号码</td>
			<td><input type="text" name="cellphone" value="${user.cellphone }"/></td>
		</tr>
		<tr>
			<td>邮箱</td>
			<td><input type="text" name="email" value="${user.email }"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="修改用户"/>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>