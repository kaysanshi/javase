<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>信商学生成绩综合管理系统</title>
<link href="login/images/login.css" rel="stylesheet" type="text/css" />
<script>
		function login(){
			var username=document.getElementById("username").value;
			if(username==""|| username==null){
				alert("请输入用户名");
				username.focus();
				return false;
			}
			var password=document.getElementById("password").value;
			if(password==""|| password==null){
				alert("请输入密码");
				password.focus();
				return false;
			}
			var checkcode=document.getElementById("checkcode").value;
			if(checkcode==""|| checkcode==null){
				alert("请输入验证码");
				password.focus();
				return false;
			}
			
	  		
			//用超链接提交表单；
			document.getElementById("form2").submit();
		}
		//通过获取时间实例化这个img的文件名字
		function changeImg(img){
  			img.src = img.src+"?time="+new Date().getTime();
  		}
</script>
</head>



<body onload="document.form2.username.focus();">
<form id="form2" name="form2" method="post" action="login_do.jsp">
    <div id="login">
	
	     <div id="top">
		      <div id="top_left"><img src="login/images/login_03.gif" /></div>
			  <div id="top_center"></div>
		 </div>
		 
		 <div id="center">
		      <div id="center_left"></div>
			  <div id="center_middle">
			       <div id="user">用&nbsp;&nbsp;户
			         <input type="text" id="username" name="username" value=""/>
			       </div>
				   <div id="pwd">密&nbsp;&nbsp;码
				     <input type="password" id="password" name="password" value=""/>
				   </div>
				   <div class="aa">角色
				   	<select id="role" name="role">
				   		<option value="student"> 学生</option>
				   		<option value="teacher">教师</option>
				   		<option value="admin">教务人员</option>
				   		<option></option>
				   	</select>
				   	</div>
				   <div class="aa">验证码
				     <input type="text" id="checkcode" name="checkcode" size="4" style='width:50px' />
				     <img id="checkcodeimg" src="${pageContext.request.contextPath }/ValiImage" onclick="changeImg(this);"/>
				   </div>
				   
				   <div id="btn" style='padding-left:40px'><a href="javascript:login();">登录</a></div>
			  </div>
			  
			  <div id="center_right"></div>		 
		 </div>
		 <div id="down">
		      <div id="down_left">
			      <div id="inf">
                       <span class="inf_text"></span>
					   <span class="copyright">信息技术系 技术支持</span>
			      </div>
			  </div>
			  <div id="down_center"></div>		 
		 </div>

	</div>
</form>



</body>
</html>

