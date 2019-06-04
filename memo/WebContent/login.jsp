<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人备忘录系统-登录</title>
<link rel="stylesheet" href="/memo/css/bootstrap.min.css" />
<link rel="stylesheet" href="/memo/css/login.css" type="text/css" />
<style>
    /*web background*/
    .container{
        display:table;
        height:100%;
    }
    .row{
        display: table-cell;
        vertical-align: middle;
    }
    /* centered columns styles */
    .row-centered {
        text-align:center;
    }
    .col-centered {
        display:inline-block;
        float:none;
        text-align:left;
        margin-right:-4px;
    }
    .well {
        background: rgba(0,0,0,0.1);
    }
    .msg {
        display: inline-block;
        height: 20px;
        text-align: center;
        color: red;
    }
</style>
</head>
<body>
<div class="bg">
    <div class="container">
        <div class="row row-centered">
            <div class="well col-md-3 col-centered">
                <h3>个人备忘录</h3>
                <span class="msg">${msg }</span>
                <form action="/memo/user_login" method="post" role="form" onsubmit="return confirm();">
                    <div class="input-group input-group-md">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" id="username" name="username" placeholder="请输入账号"/>
                    </div>
                    <div class="input-group input-group-md">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码"/>
                    </div>
                    <br/>
                    <button type="submit" class="btn btn-success">登录</button>

                    <button type="button" class="btn btn-success" id="register-btn">注册</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script src="/memo/js/jquery-1.11.0.min.js"></script>
<script src="/memo/js/bootstrap.min.js"></script>
<script>
	$('#register-btn').click(function() {
		window.location.href='/memo/register.jsp'
	});
    function confirm() {
        if ($("#username").val() == "" ||$("#password").val() == "") {
            alert("账号或密码不能为空!");
            return false;
        }
        return true;
    }
</script>
</html>