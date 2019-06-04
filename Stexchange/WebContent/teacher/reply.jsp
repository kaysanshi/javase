<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script  type="text/javaScript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"> </script>
<title>教师回复</title>
<script>
$(function(){
	$("#save").click(function(){
		alert(123456);
			var reply=$("#reply").val();
			if($.trim(reply).length==0){
				$("#info").html("请输入回复内容");
			};
			$.ajax({
				type:'Post',
				url:'ReplySaveServlet',
				data:$("#form").serialize(),
				success: function(data){
					if(data=="1"){
					alert("回复成功");
					window.location.href="${pageContext.request.contextPath}/teacher/teacherindex.jsp";
					}
				}
			});
		});
});
</script>
</head>

<body>
		<c:if test="${sessionScope.role==teacher}">
		<script language='javascript'> alert('你没有访问权限');window.location.href=${pageContext.request.contextPath}+'/login.jsp';</script></c:if>
		<c:if test="${sessionScope.username== null ||sessionScope.username==''}">
		<script language='javascript'> alert('未登录登陆请先登录');window.location.href=${pageContext.request.contextPath}+'login.jsp';</script>
		</c:if>
		
	<form id="form" action="">
	<table border="1px" width="70%" align="center">
		<c:forEach var="r" items="${requestScope.list }">
		  <tr>
		  <td bgcolor="#CCCCCC" width="15%">标题：</td>
		  <td width="45%">${r.title}</td>
		  </tr>
		  <tr>
		  <td bgcolor="#CCCCCC" width="15%">內容：</td>
		  <td>${r.content}</td>
		  </tr>
		  <tr>
		  <td bgcolor="#CCCCCC" width="15%">回復：</td>
		  <td width="45%"><textarea rows='10' cols="30"  id="reply" name="reply"></textarea></td>
		  </tr>
		  <input type="hidden" name="id" value="${r.id}">
		 </c:forEach>
		  <tr align="center">
			<td><input type="button" id="save" value="保存"></td>
			<td><div id="info"> </div></td>	
		  </tr>
		  	
		 </table>
	</form>

</body>
</html>