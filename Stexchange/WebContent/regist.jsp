<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/regist.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js" ></script>
</head>
<script>
		$(function(){ 
			$("#adduserBtn").bind("click",function(){  
			
			   var user=$("#user");
			   if($.trim(user.val()).length==0){
					$("#tipinfo").html("用户名不能为空！");
					user.focus();
					return;
			   }else{
					$("#tipinfo").html("");
			   }
		
			   var password=$("#password");
			   if($.trim(password.val()).length==0){
					$("#tipinfo").html("密码不能为空！");
					author.focus();
					return;
			   }else{
					$("#tipinfo").html("");
			   }
		
			   var verfycode=$("#verfycode");
			   if($.trim(verfycode.val()).length==0){
					$("#tipinfo").html("验证码不能为空！");
					content.focus();
					return;
			   }else{
					$("#tipinfo").html("");
			   }
			   //验证通过后，用AJAX提交请求
			   $.ajax({
					 type: 'POST',
					 url:'RegistServlet',
					 data:$("#form1").serialize(),
					 success: function(data) {
						  //data代表服务端返回的数据
						  if($.trim(data)=="1"){//添加成功
								//设置提示信息为绿色
								$("#tipinfo").css("color","green");
								$("#tipinfo").html("添加用户成功");      
								//
								setTimeout('ajaxLoadAddUserPage()',1000);
	
						  }else{//添加失败
							   $("#tipinfo").html("添加用户失败");
						  		alert("!!!");
						  }   
					 }
				});
		});  
}); 

//用AJAX加载添加用户页面
function ajaxLoadAddUserPage(){
		$.ajax({
			 type: 'GET',
			 url: '' ,
			 success: function(data) {
				 window.location.href ="../Stexchange/login.jsp";
			 }
		 });	
}
		 function changeImg(img){
  			img.src = img.src+"?time="+new Date().getTime();
  		}
		
		
		</script>
    <body>
	   <p class="biaoti">用户注册<p>
	   <form id="form1">
	   <table align="center" width="500px;" border="0" cellpadding="0" cellspacing="0" class="biao">	
	              <tr>
					<td class="biaotou">用户名：</td>
					<td class="neirong">
					    <input id="user" name="user" type="text"/>
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
					<td class="biaotou">验证码：</td>
					<td class="neirong">
					    <input id="verfycode" name="verfycode" type="text"/>
					    <td id="valistr_msg">${msg }</td>
                    	<td class="valimage"><img src="${pageContext.request.contextPath}/ValiImg" onclick="changeImg(this)" style="cursor: pointer;"/></td>
	              </tr>

				  <tr>
				  	<td id="tipinfo"></td>	
					<td class="neirong" ><input type="button" id="adduserBtn" name="submit" value="保存" width="100px;"></td>
	              </tr>	
		</table>
		</form>	 
    </body>
</html>