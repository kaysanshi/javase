<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师管理平台</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/teacherindex.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js" ></script>
	</head>
	<script type="text/javascript">
		$(function(){
			//学生列表
			$("#liststuent").bind("click",function(){
				$.ajax({
					type:"get",
					url:'ListStudentServlet',
					success:function(data){
						alert(data);
						$("#content").html(data);
						}
				});
			});
			//教师
			$("#listteacher").bind("click",function(){
				$.ajax({
					type:"get",
					url:'ListTeacherServlet',
					success:function(data){
						alert(data);
						$("#content").html(data);
						}
				});
			});
			//文件列表
			$("#listfile").bind("click",function(){
				$.ajax({
					type:"get",
					url:'ListAllFilesServlet',
					success:function(data){
						alert(data);
						$("#content").html(data);
						}
				});
			});
			////视频列表
			$("#listvideo").bind("click",function(){
					$.ajax({
						type:"get",
						url:"ListAllVideoServlet",
						success:function(data){
							$("#content").html(data);
						}
					});
			});
			//交流区
			$("#exchange").bind("click",function(){
					$.ajax({
						type:"get",
						url:"ListAllMessageServlet",
						success:function(data){
							$("#content").html(data);
						}
					});
			});
			//个人中心
			$("#myhome").bind("click",function(){
					$.ajax({
						type:"get",
						url:"AddminHomeServlet",
						success:function(data){
							$("#content").html(data);
						}
				});
		});
		});
	</script>
	<body>
		<div id="top">
			<ul>
				<li><a href="javascript:void(0)" id="liststuent">学生列表</a></li>
				<li><a href="javascript:void(0)" id="listteacher">教师列表</a></li>
				<li><a href="javascript:void(0)" id="listfile">文件列表</a></li>
				<li><a href="javascript:void(0)" id="listvideo">视频列表</a></li>
			</ul>
			<ul id="right">
				<li><a href="">欢迎你${sessionScope.username}</a></li>
				<li><a href="javascript:void(0)" id="myhome">个人中心</a></li>
			</ul>
		</div>
		<div id="content">
			显示内容
		</div>
		<div id="bottom">
			
		</div>
	</body>
</html>