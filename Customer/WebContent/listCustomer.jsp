<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户列表</title>
<script type="text/javascript">
	function checkAll(allC){
		var otherCs = document.getElementsByName("delId");
			for(var i=0;i<otherCs.length;i++){
				otherCs[i].checked = allC.checked;
			}
		
	}

</script>
</head>
<body style="text-align:center">
	<h1>客户列表页面</h1>
	<!-- 条件查询 -->
	<form action="${pageContext.request.contextPath }/FindCustomerServlet">
		客户姓名:<input type="text" name="name" value="${param.name }"/>
  		客户性别:
  				<input type="radio" name="gender" value="男"
  						<c:if test="${param.gender=='男' }">checked='checked'</c:if>
  					/>男
  					<input type="radio" name="gender" value="女"
  						<c:if test="${param.gender=='女' }">checked='checked'</c:if>
  					/>女
  					<input type="radio" name="gender" value=""/>无
  		客户类型:
	  			<select name="type">
					<option value=""
						<c:if test="${param.type=='' }">
							 selected="selected"
						</c:if>
					></option>
					<option value="钻石客户"
						<c:if test="${param.type=='钻石客户' }">
							 selected="selected"
						</c:if>
					>钻石客户</option>
					<option value="白金客户"
						<c:if test="${param.type=='白金客户' }">
							 selected="selected"
						</c:if>
					>白金客户</option>
					<option value="黄金客户"
						<c:if test="${param.type=='黄金客户' }">
							 selected="selected"
						</c:if>
					>黄金客户</option>
					<option value="白银客户"
						<c:if test="${param.type=='白银客户' }">
							 selected="selected"
						</c:if>
					>白银客户</option>
					<option value="青铜客户"
						<c:if test="${param.type=='青铜客户' }">
							 selected="selected"
						</c:if>
					>青铜客户</option>
					<option value="黑铁客户"
						<c:if test="${param.type=='黑铁客户' }">
							 selected="selected"
						</c:if>
					>黑铁客户</option>
					<option value="没牌客户"
						<c:if test="${param.type=='没牌客户' }">
							 selected="selected"
						</c:if>
					>没牌客户</option>
				</select>
		<input type="submit" value="条件查询客户"/>
		
	
	</form>
	<form action="${pageContext.request.contextPath }/BatchDeleteCustomerServlet" method="post">
	<table border="1">
		<tr>
			<th><input type="checkbox" name="" onclick="checkAll(this)">全选</th>
			<th>客户姓名</th>
			<th>客户性别</th>
			<th>出生日期</th>
			<th>手机号码</th>
			<th>客户邮箱</th>
			<th>客户爱好</th>
			<th>客户类型</th>
			<th>客户描述</th>
			<th>修改</th>
		</tr>
			<c:forEach items="${requestScope.list}" var="customer">
			<tr>
			<td><input type="checkbox" name="delId" value="${customer.id }"></td>
			<td><c:out value="${customer.name}"></c:out> </td>
			<td><c:out value="${customer.gender}"></c:out></td>
			<td><c:out value="${customer.birthday}"></c:out> </td>
			<td><c:out value="${customer.cellphone}"></c:out></td>
			<td><c:out value="${customer.email}"></c:out></td>
			<td><c:out value="${customer.preference}"></c:out> </td>
			<td><c:out value="${customer.type}"></c:out></td>
			<td><c:out value="${customer.description}"></c:out></td>	
			<td><a href="${pageContext.request.contextPath }/CustomerInfoServlet?id=${customer.id}">修改</a></td>	
			<td><a href="${pageContext.request.contextPath }/DelCustomerservlet?id=${customer.id}">删除</a></td>	
			
			</tr>
			</c:forEach>
	</table>
	<input type="submit" value="批量删除">
</form>
</body>
</html>