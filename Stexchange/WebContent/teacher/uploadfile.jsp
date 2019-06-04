<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>

<title>文件的上传</title>
</head>
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
				 var formData = new FormData($('#form')[0]); 
				 //formData.append('description',$("desc").val());
				$.ajax({
					type:'Post',
					url:'UploadfileServlet',
					data:formData,
					cache: false,  
	                processData: false,  
	                contentType: false,
					success:function(data){
						if(data=="1"){
							$("#info").html("上传成功");
						}else{
							$("#info").html("上传失败");
							alert("上传失败"); 
						}
					}
				});
			});
			
		});
	</script>
<body>
	<c:if test="${sessionScope.role==teacher}">
		<script language='javascript'> alert('你没有访问权限');window.location.href=${pageContext.request.contextPath}+'/login.jsp';</script></c:if>
	<c:if test="${sessionScope.username== null ||sessionScope.username==''}">
		<script language='javascript'> alert('未登录登陆请先登录');window.location.href=${pageContext.request.contextPath}+'login.jsp';</script>
	</c:if>
	<form id="form" action="" enctype="multipart/form-data">
		<table>
			<tr>
				<td>请选择文件：</td>
				<td><input type="file" name="file"/></td>
			</tr>
			<tr>
				<td>文件名:</td>
				<td><input type="text" name="filetitle" id="filetitle"></td>
			</tr>
			<tr>
				<td>文件描述:</td>
				<td>
					<textarea rows='10',cols="30"  id="desc" name="desc"></textarea>
				</td>
			</tr>
			<tr>
				<td>
				<input type="button" id="button" value="上传">
				</td>
			</tr>
			<tr>
				<td><div id="info"></div></td>
			</tr>
		</table>
	</form>
</body>
</html>