<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎来到校规校纪学习系统</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index.css">
</head>
<script type="text/javascript">
	function regist() {
		window.location.assign("regist.jsp");
	}
	function open_win(){
		
		window.open("http://localhost:8080/SafeDemo/studyauto.jsp","_blank"," toolbar=yes, location=yes, directories=no, status=no, menubar=yes, scrollbars=yes, resizable=no, copyhistory=yes, width=400, height=400");
	}
	function logout(){
		window.location.href="LogoutServlet";
	}
	window.onload=function(){
		document.getElementById("btn").onclick=function(){
			var zh=document.getElementById("zhanghao").value;
			var pwd=document.getElementById('pwd').value;
			//alert(pwd);
			//alert(tel);
	
			if(zh ==null || zh==""){
				alert("请输入账号 ");
			}else if(pwd==null || pwd==""){
				alter("请输入密码");
				}
			}
		}
</script>
<body>
	<div id="login">
		<div class="log">
			<img src="images/logo.jpg"/>
		</div>
		<div class="login">	
		<form action="${pageContext.request.contextPath }/LoginServlet" method="post">
			<table>
			<c:if test="${sessionScope.user == null}">
			<tr>
				<td>账号</td>
				<td><input type="text" id="zhanghao" name="username" value="" placeholder="${msg }"></td>
				<td ><a href="${pageContext.request.contextPath }/user/regist.jsp" style="color:red;">注册</a></td>
				<td ><a href="${pageContext.request.contextPath }/user/user.jsp" style="">个人</a></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" id="pwd" name="password" value="" placeholder="${msg_p }"></td>
				<td style="color:red; text-decoration:underline;">未登录</td>
			</tr>
			<tr>
				<td><input type="submit" name="" id="btn" value="登录"></td>
			</tr>
			</c:if>
			<c:if test="${sessionScope.user != null}">
			<tr>
				<td>账号</td>
				<td><input type="text" name="user" value=""></td>
				<td> <a href="${pageContext.request.contextPath }/user/regist.jsp"> 注册</a></td>
				<td ><a href="${pageContext.request.contextPath }/user/user.jsp" style="">个人</a></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password" value=""></td>
				<td color="red">已登录</td>
			</tr>
			<tr>
				<td><input type="button" name="" value="注销" onclick="logout()"><br/></td>
			</tr>
			</c:if>
		</table>
		</form>`
		
		</div>
		
	</div>
	<hr style="width:1300px;margin:0px auto;">
    <div id="head">
            <ul>
                <li>
                	<a href="${pageContext.request.contextPath}/GetPlayServlet">视频学习</a>
                </li>
                <li><a href="${pageContext.request.contextPath}/ExamieServlet">在线测评</a></li>
                <li><a href="#">实时新政</a></li>
                <li><a href="#">外校校规</a></li>
                <li><a href="#">在线讲座</a></li>
                <li><a href="#">校规交流</a></li>
                <li><a href="#">网上大赛</a></li>
            </ul>
    </div>
    <div id="ask">
			<a href="#" onclick="open_win()"></a>   
	</div>
    <div id="center">
    	<div class="left">
            <video width="900px" height="300px" src="${requestScope.filepath}" controls="controls" poster="images/shipin.png">  
            </video>
            
        </div>
        <div class="right">
        	
			<ul>
				<li><a href="javascript:void(0)">你身边的大学生日常规范演示实例</a></li>
				<li><a href="">他们的这些行为合适吗？</a></li>
				<li><a href="">你赞同他们的说法吗？</a></li>
				<li><a href="">这是不是你也有过的经历呢？</a></li>
				<li><a href="">是不是与本人有关的事件呢？</a></li>
				<li><a href="">你get到了这些技能了吗？</a></li>
			</ul>
        </div>
    </div>
    <div id="content">
		<div class="title">
			<h3>新闻资讯</h3>
			<hr>
		</div>
		<div class="content_list">
			<ul>
				<li><a href="">中共中央党组织委员会十分重视校园平安问题</a></li>
				<li><a href="">中原工学院成功举行校园安全问题讨论会及其方案</a></li>
				<li><a href="">中原工学院信息商务学院开展安全知识竞赛周活动</a></li>
				<li><a href="">“培训贷”：打着金融创业旗号的“培训贷”实为“校园贷”的新变种，专门坑骗涉世未深的大学生。</a></li>
				<li><a href="">“裸条贷”：主要指不法债主通过要挟借贷者以裸照或不雅视频作为贷款抵押证据的行为。</a></li>
				<li><a href="">“刷单贷”：主要指不法分子利用大学生求职心理，以贷款购物刷单获取佣金名义进行的新型诈骗。</a></li>
			</ul>
		</div>
		<div class="content_right">
			<a href=""><img src="images/zixun.jpg" alt="图片"></a>
		</div>
    </div>
    <div id="bottom">
    	<div class="bottom_left">
    		<h3>资源共享></h3>
    		<hr/>
    		<ul>
				<li><a href="#">公共资源整合区</a></li>
				<li><a href="#">学习资源整合区</a></li>
				<li><a href="#">公开课资源项目整合库</a></li>
				<li><a href="#">专业课资源项目整合库</a></li>
				<li><a href="#">软件资源项目整合库</a></li>
				<li><a href="#">系统资源项目整合库</a></li>
		
    		</ul>
    	</div>
    	<div class="bottom_right">
    		<h3>娱乐天地></h3><hr/>
    		<ul>
    			<li><a href="#"><img src="images/yule.png" height="80px" width="495px" alt="play" /></a></li>
    		</ul>	
    		<ul>
				<li><a href="#">遇见不一样的新玩法期待你的加入</a></li>
    		</ul>
    	</div>
    </div>
    <div id="foot">
    	<hr/>
    		<ul style="height:30px; width:1300px;margin:0px auto; background-color:#2095883;">
    			<li>友情链接></li>
    		</ul>
    		<hr/ width="30%">
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
