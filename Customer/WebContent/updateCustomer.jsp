<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改客户信息</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/UpdateCustomerServlet" method="post">
	<input type="hidden" name="id" value="${customer.id }"/>
	<table>
		<tr>
			<td>客户姓名</td>
			<td><input type="text" name="name" value="${customer.name }" readonly="readonly"/></td>
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
			<td>出生日期</td>
			<td><input type="text" name="birthday" value="${customer.birthday}"/></td>
		</tr>
		<tr>
			<td>手机号码</td>
			<td><input type="text" name="cellphone" value="${customer.cellphone }"/></td>
		</tr>
		<tr>
			<td>邮箱</td>
			<td><input type="text" name="email" value="${customer.email }"/></td>
		</tr>
		<tr>
			<td>客户爱好</td>
			<td>
			
				<input type="checkbox" name="preference" value="篮球"
				<c:forTokens items="${customer.preference }" delims="," var="pref">
					<c:if test="${pref='篮球' }">
					checked='checked'
					 </c:if>
				</c:forTokens>
				>篮球
				<input type="checkbox" name="preference" value="足球"
				<c:if test="${fn:contains(customer.preference,'足球') }">
					checked='checked'
				</c:if>
				
				/>足球
				<input type="checkbox" name="preference" value="排球"
				<c:if test="${fn:contains(customer.preference,'排球') }">
					checked='checked'
				</c:if>
				/>排球
				<input type="checkbox" name="preference" value="棒球"
				<c:if test="${fn:contains(customer.preference,'棒球') }">
					checked='checked'
				</c:if>/>棒球
				<input type="checkbox" name="preference" value="乒乓球"
				<c:if test="${fn:contains(customer.preference,'乒乓球') }">
					checked='checked'
				</c:if>
				/>乒乓球
				<input type="checkbox" name="preference" value="羽毛球"
				<c:if test="${fn:contains(customer.preference,'羽毛球') }">
					checked='checked'
				</c:if>
				/>羽毛球
				<input type="checkbox" name="preference" value="冰球"
				<c:if test="${fn:contains(customer.preference,'冰球') }">
					checked='checked'
				</c:if>
				/>冰球
			
			</td>
		</tr>
		<tr>
			<td>客户类型</td>
			<td>
				<select name="type">
					<option value="砖石客户"
					<c:if test="${customer.type='砖石客户' }">selected='selected'</c:if>
					>砖石客户</option>
					<option value="白金客户"
					<c:if test="${customer.type='白金客户' }">selected='selected'</c:if>
					>白金客户</option>
					<option value="黄金客户"
					<c:if test="${customer.type='黄金客户' }">selected='selected'</c:if>
					>黄金客户</option>
					<option value="白银客户"
					<c:if test="${customer.type='白银客户' }">selected='selected'</c:if>
					>白银客户</option>
					<option value="青铜客户"
					<c:if test="${customer.type='青铜客户' }">selected='selected'</c:if>
					>青铜客户</option>
					<option value="红砖客户"
					<c:if test="${customer.type='红砖客户' }">selected='selected'</c:if>
					>红砖客户</option>
				
				</select>
			</td>
		</tr>
		<tr>
			<td>描述信息</td>
			<td>
				<textarea name="description"  rows="20" cols="30" />${customer.description }</textarea>
			</td>
		</tr>
		<tr>
			
			<td colspan="2">
				<input type="submit" value="修改客户"/>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>