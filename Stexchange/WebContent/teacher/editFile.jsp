<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改文件</title>
<script>
		$(function(){
			$("#button").click(function(){
				//验证是否为空
				var desc=$("#desc");
				alert(desc.val());
			       if($.trim(desc.val()).length==0){
			            $("#info").html("请添加描述信息");
			            $("#info").css("color","red");
			            desc.focus();
			            return;
			       }else{
			            $("#info").html("");
			       }
			       
			     var filetitle=$("#filetitle");
			     if($.trim(filetitle.val()).lengeth==0){
			    	 $("#info").html("请输入文件名");
			    	 $("#info").css("color","red");
			    	 filetitle.focus();
			    	 return;
			     }else{
			    	 $("#info").html("");
			     }
				
				$.ajax({
					type:'Post',
					url:'SaveEditFileServlet',
					data:$("#form").serialize(),
					success:function(data){
						if(data=="1"){
							$("#info").html("修改成功");
						}else{
							$("#info").html("修改失败");
						}
					}
				});
			});
			
		});
	</script>
</head>
<body>
		<form id="form" action="">
		<table>
		<c:forEach var="r" items="${requestScope.list }">
			<input type="hidden" name="id" value="${r.id}">
			<tr>
				<td>文件名:</td>
				<td><input type="text" name="filetitle" id="filetitle" value="${r.filetitle }"></td>
			</tr>
			<tr>
				<td>文件描述:</td>
				<td>
					<textarea rows='10',cols="30"  id="desc" name="desc" value="${r.description}"></textarea>
				</td>
			</tr>
			<tr>
				<td>
				<input type="button" id="button" value="修改">
				</td>
			</tr>
			<tr>
				<td><div id="info"></div></td>
			</tr>
			</c:forEach>
		</table>
	</form>	
</body>
</html>