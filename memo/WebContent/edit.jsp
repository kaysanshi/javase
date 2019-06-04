<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>个人备忘录系统-编辑</title>
    <link rel="stylesheet" href="/memo/css/bootstrap.min.css" />
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
            background: url(/memo/images/timg.jpg) no-repeat #000;
            width: 800px;
            height: 400px;
            border: 0px;
        }
        .add {
            margin-top: 120px;
            text-align: center;
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
        <div class="well col-md-9 col-centered">
            <div class="add">
                <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default">标题</button>
                    </span>
                    <input type="text" class="form-control" id="title" name="title" value="${record.title }">
                </div>
                <br/>
                <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default">内容</button>
                    </span>
                    <input type="text" class="form-control" id="content" name="content" value="${record.text }">
                </div>
                <br/>
                <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button">日期</button>
                    </span>
                    <input type="text" class="form-control" id="date" name="date" value="${record.time }">
                </div>
                <br/>
                <button type="button" class="btn btn-success btn-block" id="save-btn" url="${record.id }">保存</button>
            </div>
        </div>
    </div>
</div>
</body>
<script src="/memo/js/jquery-1.11.0.min.js"></script>
<script src="/memo/js/bootstrap.min.js"></script>
<script src="/memo/laydate/laydate.js"></script>
<script>
	lay('#version').html('-v'+ laydate.v);
	
	//执行一个laydate实例
	laydate.render({
	    elem: '#date' //指定元素
	});
	
	$(function () {
	    $('#save-btn').click(function () {
	        if ($('#title').val() == "" || $('#content').val() == "" || $('#date').val() == "") {
	            alert("内容不全！");
	        } else {
	            var ttitle = $('#title').val();
	            var tcontent = $('#content').val();
	            var tdate = $('#date').val();
	            $.ajax({
	                url:'/memo/rd_save',
	                type:'POST',
	                data:{title:ttitle,content:tcontent,date:tdate,id:$(this).attr('url')},
	                dataType:'json',
	                success:function(data) {
	                    alert(data['msg']);
	                    if (data['status'] == 0) {
	                        $('#tiltle').val(ttitle);
	                        $('#content').val(tcontent);
	                        $('#date').val(tdate);
	                    }
	                    if (data['status'] == 1)
	                        window.location.href='/memo/rd_list';
	                },
	                error:function() {
	                    alert("操作提交失败");
	                    $('#tiltle').val(ttitle);
	                    $('#content').val(tcontent);
	                    $('#date').val(tdate);
	                }
	            });
	        }
	    });
	});
</script>
</html>