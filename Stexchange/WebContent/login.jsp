<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"  type="text/css" href="${pageContext.request.contextPath}/css/index.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js" ></script>
<title>欢迎来到在线交流平台</title>
<script>
				$(function (){
			    //登录,的单击动作
				 $(".btn-green").bind("click",function(){  
				       //验证账号
				       var username=$("#username");
				       if($.trim(username.val()).length==0){
				            $("#tipinfo").html("账号不能为空！");
				            $("#tipinfo").css("color","red");
				            username.focus();
				            return;
				       }else{
				            $("#tipinfo").html("");
				       }
				       //验证账号
				       var password=$("#password");
				       if($.trim(password.val()).length==0){
				            $("#tipinfo").html("密码不能为空！");
				            password.focus();
				            return;
				       }else{
				            $("#tipinfo").html("");
				       }
				       //验证通过后，用AJAX提交请求
				       $.ajax({
						     type: 'POST',
						     url: 'LoginServlet',
						     data: $("#form").serialize(),
						     success: function(data) {
						          //data代表服务端返回的数据
						          if($.trim(data)=="1"){//登录成功跳转到系统主页
						               location.href="student/stuindex.jsp";
						          }else if($.trim(data)=="2"){
						        	  location.href="teacher/teacherindex.jsp";
						          }else if($.trim(data)=="3"){
						        	  location.href="addmin/addminindex.jsp";
						          }else{
						        	  $("#tipinfo").html("用户名或密码错误");
						          }
						     }
						}); 
				 });  
				});
		
	</script>
</head>
	<body>
	<div id="top">
		<a href="regist.jsp" style="color:red">注册</a>
	</div>
	<div id="tab">
		
	</div>
	<div id="login">
	<p class="biaoti">用户登录<p>
	<form id="form" action="">
	   <table align="center" width="400" border="0" cellpadding="0" cellspacing="0" class="biao">	
	              <tr>
					<td class="biaotou">账号：</td>
					<td class="neirong">
					    <input id="username" name="username" type="text"/>
					</td>
	              </tr>
				  <tr>
					<td class="biaotou">密码：</td>
					<td class="neirong">
					    <input id="password" name="password" type="password"/>
					</td>
	              </tr>
	              <tr>
					<td class="biaotou">角色：</td>
					<td class="role">	
					   <label class="role1"> 
					   	<input type="radio" name="role" checked="checked" id="inlineRadio" value="student">
								学生
						</label> 
						<label class="role1"> 
							<input type="radio" name="role" id="inlineRadio" value="teacher">
								教师
							</label>
						<label class="role1"> 
							<input type="radio" name="role" id="inlineRadio" value="admin">
								管理员
						</label>
						</td>
	              </tr>
				  <tr>
				  	<td id="tipinfo"></td>
					<td class="neirong">
					    <a href="javascript:void(0);" class="btn-green">登&nbsp;录</a>
					</td>
					
	              </tr>	
		</table>
		</form>
	</div>
	<div id="bottom">
		<p></p>
	</div>
	</body>
</html>