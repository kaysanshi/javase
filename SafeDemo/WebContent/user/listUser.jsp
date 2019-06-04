<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
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
	<h1>用户列表页面</h1>
	<!-- 条件查询 -->
	<form action="${pageContext.request.contextPath }/FindUserServlet">
		用户姓名:<input type="text" name="username" value="${param.username }"/>
  		用户性别:
  				<input type="radio" name="gender" value="男"
  						<c:if test="${param.gender=='男' }">checked='checked'</c:if>
  					/>男
  					<input type="radio" name="gender" value="女"
  						<c:if test="${param.gender=='女' }">checked='checked'</c:if>
  					/>女
  					<input type="radio" name="gender" value=""/>无
		<input type="submit" value="条件查询客户"/>
		
	
	</form>
	<form action="${pageContext.request.contextPath }/BatchDeleteUserServlet" method="post">
	<table border="1">
		<tr>
			<th><input type="checkbox" name="" onclick="checkAll(this)">全选</th>
			<th>姓名</th>
			<th>用户名</th>
			<th>性别</th>
			<th>学号</th>
			<th>手机号</th>
			<th>Email</th>
			<th>注册时间</th>
			<th>修改</th>
		</tr>
			<c:forEach items="${requestScope.list}" var="user">
			<tr>
			<td><input type="checkbox" name="delId" value="${user.userid }"></td>
			<td><c:out value="${user.username}"></c:out> </td>
			<td><c:out value="${user.nickname}"></c:out> </td>
			<td><c:out value="${user.gender}"></c:out></td>
			<td><c:out value="${user.stunumber}"></c:out></td>
			<td><c:out value="${user.cellphone}"></c:out> </td>
			<td><c:out value="${user.email}"></c:out></td>
			<td><c:out value="${user.addtime}"></c:out></td>	
			<td><a href="${pageContext.request.contextPath }/UserInfoServlet?id=${user.userid}">修改</a></td>	
			<td><a href="${pageContext.request.contextPath }/DelUserServlet?id=${user.userid}">删除</a></td>	
			
			</tr>
			</c:forEach>
	</table>
	<input type="submit" value="批量删除">
</form>
</body>
</html>