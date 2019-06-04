<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <title>注册界面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/regist.css">
    <script language="javascript" src="${pageContext.request.contextPath }/js/regist.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js" ></script>
		<!--引入validate插件js文件-->
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.min.js" ></script>
		<!--引入国际化js文件-->
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/messages_zh.js" ></script>
    <script type="text/javascript">
        function changeImg(img){
  			img.src = img.src+"?time="+new Date().getTime();
  		}
    </script>
    <!--  
    <script>
    	$(function(){
    		$("#form1").validate({
    			rlues:{
    				user:{
    					required:true,
    					minlength:3,
    				},
    				password:{
    					required:true,
    					minlength:3,
    					digits:true,
    				}
    			},
    			messages:{
    				user:{
    					required:"不能为空",
    					minlength:"不能少于三位",
    				},
    				password:{
    					required:"不能为空",
    					minlength:"不能少于三位",
    					digits:"必须是整数"
    				}
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
    -->
</head>
<body>
<div id="head"> 
     <img src="../images/logo.jpg" alt="">
</div>
<div id="center">
   <div id="main">
            <ul id="pic">
             <li><a href="#"><img width="800px" src="../images/26.jpg" alt=""></a></li>
             <li><a href="#"><img width="800px" src="../images/log.jpg" alt=""></a></li>
            </ul>
            <ul id="list">
             <li><a href="#"></a></li>
             <li><a href="#"></a></li>
             <li><a href="#"></a></li>
             <li><a href="#"></a></li>
             <li><a href="#"></a></li>
            </ul>
    </div>
    <div class="dl">
        <form id="form1" action="${pageContext.request.contextPath }/RegistServlet" method="post">
            <div class="wz1">用户注册</div>
            <table>
                <tr>
                    <td><input type="text" name="username" placeholder="用户名" class="user"  id="username" required=""  /></td>
                </tr>
                <tr>
                    <td><input type="password" name="password" placeholder="密码" class="password"  id="password" required=""/></td>
                </tr>
                <tr>
                    <td><input type="text" name="valistr" placeholder="验证码" class="vcode" required=""/></td>
                    <td id="valistr_msg">${msg }</td>
                    <td class="valimage"><img src="${pageContext.request.contextPath}/ValiImg" onclick="changeImg(this)" style="cursor: pointer;"/></td>
                </tr>
                
                <tr>
                    <td>
                        <input  class="an" type="submit" value="注册"/>
                    </td>
                </tr>
            </table>
        </form>
     </div>
</div>
<div id="bottom">
		<div class="b_one">
			<a href="#"><img width="400px" height="260px" src="../images/tu1.gif" alt=""></a>
		</div>
		<div class="b_two">
			<a href="#"><img width="493px" height="260px"  src="../images/tu2.jpg" alt=""></a>
		</div>
		<div class="b_three">
			<a href="#"><img width="400px" height="260px"  src="../images/tu3.jpg" alt=""></a>
		</div>
</div>
 <div id="foot">
    	<hr/>
    		<ul style="height:30px; width:1300px;margin:0px auto; background-color:#2095883;">
    			<li>友情链接></li>
    		</ul>
    	<hr/>
    	<ul style="height:40px; width:1300px;margin:0px auto;">
    	
    	<li><a href="http://www.eol.cn/">&nbsp;&nbsp;&nbsp;&nbsp;中国教育网</a></li>
    	<li><a href="http://anquan.tongyi.com/">&nbsp;&nbsp;&nbsp;&nbsp;安全教育网</a></li>
    	<li><a href="http://www.chsi.com.cn/">&nbsp;&nbsp;&nbsp;&nbsp;学信网</a></li>
    	<li><a href="http://www.zut.edu.cn/">&nbsp;&nbsp;&nbsp;&nbsp;中原工学院</a></li>
    	<li><a href="http://www.zcib.edu.cn/">&nbsp;&nbsp;&nbsp;&nbsp;中原工学院信息商务学院</a></li>
    	</ul>
   </div>
</body>
</html>