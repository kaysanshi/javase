<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人备忘录系统-主页</title>
<link href="/memo/css/bootstrap.min.css" rel="stylesheet">
<link href="/memo/css/common.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a href="/memo/home.jsp" class="navbar-brand">备忘录</a>
        </div>
        <div id="navbar" class="">
            <!-- 要想使用navbar-tabs必须有nav这个基类 -->
            <ul class="nav navbar-nav">   
                <li><a href="/memo/add.jsp">新建</a></li>
                <li><a href="/memo/rd_list">列表</a></li>
            </ul>
        </div>
        <div class="navbar-right nav-right dropdown">
            <img class="img-circle header-img" src="/memo/images/header.jpg" width="48" height="48"/>
            <a href="#" data-toggle="dropdown" aria-expanded="false">
                <span>${user.nick }</span>
                <span class="caret"></span>
            </a>
            <ul class="dropdown-menu" role="menu">

                <li><a href="/memo/pwd.jsp">修改密码</a></li>

                <li><a href="/memo/user_exit">退出</a></li>
            </ul>
        </div>
    </div>
</nav>
<nav class="content">
         欢迎登录个人备忘录系统<br>
    上次登录时间：${user.last_login_time }<br>
    上次登录IP：${user.last_login_ip }
</nav>
</body>
<script src="/memo/js/jquery-1.11.0.min.js"></script>
<script src="/memo/js/bootstrap.min.js"></script>
</html>
