<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'regist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="cal/lhgcore.js"></script>
	<script type="text/javascript" src="cal/lhgcalendar.js"></script>
    
    <script type="text/javascript">  
      function checkName(){
    	  //获取用户名
    	  var name =document.getElementById("username");
    	  //创建XMLHttpRequest对象
    	  var xmlHttp;
    	  try{
    		  xmlHttp = new XMLHttpRequest();//IE7以上，火狐，谷歌等其它浏览器
    	  }catch(e){
    		  try{
    			  xmlHttp = new ActiveObject("Msxml2.XMLHTTP");//IE6
    		  }catch(e){
    			  try{
    				  xmlHttp = new ActiveObject("Microsoft.XMLHTTP");//IE5.5以及更早的版本
    			  }catch(e){
    				  alert("你的浏览器不支持！");
    				  throw e;
    			  }
    		  }
    	  }
    	  
    	  //2.打开和服务器的连接，第一个是提交方式，第二个是提交url，第三个是否异步，true表示异步
    	  xmlHttp.open("POST","<c:url value='/userServlet'/>",true);
    	  //3.设置Content-Type请求头
    	  xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    	  //4.发送请求
    	  xmlHttp.send("username=" + name.value + "&action=checkName");
    	  //5.注册XMLHttpRequest对象的监听器，对服务器响应的进行监听，获取服务器响应，进行局部刷新。
    	  xmlHttp.onreadystatechange = function(){
    		if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
    			//获取服务器的响应内容
    			var text = xmlHttp.responseText;
    			var cunresult = document.getElementById("cunresult");
    			cunresult.innerHTML = text;
    			cunresult.style.color = "red";
    		}  
    	  };
      }
      function     check()     
         {     
			var name = document.getElementById("username");
			var pwd = document.getElementById("password");
			var pwd2 = document.getElementById("password2");
			if(!name.value ){
				document.getElementById("cunresult").innerHTML = "用户名不能为空";
				name.focus();
				return;
			}
			if(!pwd.value)
			{
				document.getElementById("cpwdresult").innerHTML = "密码不能为空";
				pwd.focus();
				return;
			}
			if(!pwd2.value)
			{
				document.getElementById("cpwd2result").innerHTML = "密码不能为空";
				pwd2.focus();
				return;
			}
			return document.getElementById("form1").submit();
         }     
    </script> 
  </head>
  
  <body>
        <h1>注册</h1>
    ${error}
    <form action="<c:url value='/userServlet'/>" method="post"  id="form1">
    	<input type="hidden" name="action" value="regist"/>
    	用户名：<input type="text" name="username" id="username" onblur="checkName()"/><span id="cunresult"></span><br/>
    	密码：<input type="password"	 name="password" id="password"/><span id="cpwdresult"></span><br/>
    	 再次输入密码：<input type="password" name="password2" id="password2"/><span id="cpwd2result"></span><br/> 
    	出生日期：<input type="text" name="birthday" onclick="J.calendar.get();"/>
    	<br/>
    	邮箱：<input type="text" name="email"/><br/>
    	<input type="button" value="注册"  onclick="check()"/>
    	<input type="reset" value="取消"/>
    </form>
  </body>
</html>
