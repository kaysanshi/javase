<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>用户注册</title>
		<link rel="stylesheet" href="css/register.css" />
		<script type="text/javascript" src="js/jquery-1.11.3.min.js" ></script>
		<!--引入validate插件js文件-->
		<script type="text/javascript" src="js/jquery.validate.min.js" ></script>
		<!--引入国际化js文件-->
		<script type="text/javascript" src="js/messages_zh.js" ></script>
		<script>
			$(function(){
				$("#registForm").validate({
					rules:{
						user:{
							required:true,
							minlength:3
						},
						password:{
							required:true,
							digits:true,
							minlength:6
						},
						repassword:{
							required:true,
							equalTo:"[name='password']"
						},
						username:{
							required:true,
							maxlength:5
						},
						
					},
					messages:{
						user:{
							required:"用户名不能为空!",
							minlength:"用户名不得少于3位!"
						},
						password:{
							required:"密码不能为空!",
							digits:"密码必须是整数!",
							minlength:"密码不得少于6位!"
						},
						repassword:{
							required:"确认密码不能为空!",
							equalTo:"两次输入密码不一致!"
						},
						
						username:{
							required:"姓名不能为空!",
							maxlength:"姓名不得多于5位!"
						},
						
					},
					errorElement: "label", //用来创建错误提示信息标签,validate插件默认的就是label
					success: function(label) { //验证成功后的执行的回调函数
						//label指向上面那个错误提示信息标签label
						label.text(" ") //清空错误提示消息
							.addClass("success"); //加上自定义的success类
					}
				});
			});
		</script>
		<script type="text/javascript">
        function changeImg(img){
  			img.src = img.src+"?time="+new Date().getTime();
  		}
    </script>
	</head>
	<body>
		<div id="bg">
		<div id="contanier">
			<div id="top">
				<div class="top_login">
					<a href="login.jsp">登录</a>
				</div>
			</div>
			<!--<div id="menu">
				<a href="#"><font size="5" color="white">/font></a>         	
			</div>-->
			<div id="form">
				<form action="${pageContext.request.contextPath }/RegistServlet"" method="get" id="registForm">
					<div id="father">
						<div id="form2">
							<table border="0px" width="100%" height="100%" align="center" cellpadding="0px" cellspacing="0px" bgcolor="white">
								<tr>
									<td colspan="2" >
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<font size="5">用户注册</font>&nbsp;&nbsp;&nbsp;USER REGISTER 
									</td>
								</tr>
								<tr>
									<td width="180px">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;
										<label for="user" >用户名</label>
									</td>
									<td>
										<em style="color: red;">*</em>&nbsp;&nbsp;&nbsp;<input type="text" name="user" size="35px" id="user"/>
									</td>
								</tr>
								<tr>
									<td>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;
										密码
									</td>
									<td>
										<em style="color: red;">*</em>&nbsp;&nbsp;&nbsp;<input type="password"  name="password" size="35px" id="password" />
									</td>
								</tr>
								<tr>
									<td>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;
										确认密码
									</td>
									<td>
										<em style="color: red;">*</em>&nbsp;&nbsp;&nbsp;<input type="password" name="repassword" size="35px"/>
									</td>
								</tr>
								
								<tr>
									<td>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;
										昵称
									</td>
									<td>
										<em style="color: red;">*</em>&nbsp;&nbsp;&nbsp;<input type="text" name="username" size="35px"/>
									</td>
								</tr>
								<tr>
									<td>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;
										验证码
									</td>
									<td>
										<em style="color: red;">*</em>&nbsp;&nbsp;&nbsp;<input type="text" name="yanzhengma" />
										<img src="${pageContext.request.contextPath}/ValiImg" onclick="changeImg(this)"  style="height: 28px;width: 100px;"/>
									</td>
								</tr>
								<tr>
									<td colspan="2">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="submit" value="注      册" height="50px"/>
										<input type="reset" value="重      置" height="50px"/>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</form>
			</div>
			<div>
				
			</div>
			<div id="bottom">
				<a href="#">关于我们</a>
				<a href="#">联系我们</a>
				<a href="#">友情链接</a>
				<p>
					Copyright © 2018 
				</p>
			</div>
		</div>
		</div>
	</body>
</html>