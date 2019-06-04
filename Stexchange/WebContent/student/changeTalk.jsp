<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生交流</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/changeTalk.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js" ></script>
</head>
	<script type="text/javascript">
		$("#button").click(function(){
			alert("111");
			
			var teacher=$('#test').val();
			alert(teacher)
			if($.trim(teacher).length==0){
				alert("请悬着用户");
			}else{
				
			};
			//
			var title=$("#title").val();
			if($.trim(title).length==0){
				alert("请输入标题");
				$("#title").focus();
				return;
			}else{
				
			};
			//
			var mscontent=$("#mscontent").val();
			if($.trim(mscontent).length==0){
				alert("请输入内容");
				$("#mscontent").focus();
				return;
			}else{
				
			};
			$.ajax({
				type:"post",
				url:'MessageSaveServlet',
				data:{teacher:teacher,
					title:title,
					mscontent:mscontent
					},
				success:function(data){
					if(data=="1"){
						alert("发送成功");
					}else{
						alert("发送失败");
					}
				}
			});

		});
	</script>
	<body>
			<form id="form">
				<table width="500px";height="300px"; border="1px solid #000000" align="center">
				<tr>
					<td>收件人</td>
					<td align="center"><select name=""id="test">
					<c:forEach var="r" items='${requestScope.list}'>
						<option id="teacher" value="${r.id }">${r.realname}</option>
						
					</c:forEach>
					</select></td>
					
				</tr>
				<tr>
					<td>标题：</td>
					<td><input type="text" name="title" id="title"></td>
				</tr>
				<tr>
					<td>内容:</td>
					<td><textarea rows="10px"; cols="100px" id="mscontent" name="mscontent"></textarea></td>
				</tr>
				<tr align="center">
					<td colspan="2">
					<input type="button" id="button" value="发送">
					</td>
				</tr>
			</table>
			</form>
	</body>
</html>