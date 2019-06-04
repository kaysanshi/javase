<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人备忘录系统-密码修改</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link href="/memo/css/common.css" rel="stylesheet">
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
</style>
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
<div class="container">
    <div class="row row-centered">
        <div class="well col-md-3 col-centered">
            <form role="form">
                <div class="input-group input-group-md">
                    <input type="text" class="form-control" id="oldpwd" name="oldpwd" placeholder="请输入原密码"/>
                </div>

                <div class="input-group input-group-md">

                    <input type="password" class="form-control" id="newpwd" name="newpwd" placeholder="请输入新密码"/>
                </div>

                <div class="input-group input-group-md">

                    <input type="password" class="form-control" id="pwd" name="pwd" placeholder="再次输入密码"/>
                </div>
                <br/>
                <div class="input-group input-group-md">

                    <button type="button" class="btn btn-success btn-block" id="pwd-btn">修改</button>
                </div>

            </form>
        </div>
    </div>
</div>
</body>
<script src="/memo/js/jquery-1.11.0.min.js"></script>
<script src="/memo/js/bootstrap.min.js"></script>
<script>
    $(function () {
        $('#pwd-btn').click(function () {
            if ($('#oldpwd').val() == "" || $('#newpwd').val() == "" ||$('#pwd').val() == "") {
                alert("密码不能为空！");
            } else if ($('#newpwd').val() != $('#pwd').val()) {
                alert("两次密码不一致！");
            } else {
                $.ajax({
                    url:'/memo/user_changepwd',
                    type:'POST',
                    data:{oldpwd:$('#oldpwd').val(), newpwd:$('#newpwd').val()},
                    dataType:'json',
                    success:function(data) {
                        alert(data['msg']);
                    },
                    error:function() {
                        alert("操作提交失败");
                    }
                });
            }
        });
    });
</script>
</html>