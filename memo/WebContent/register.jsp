<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>备忘录系统-注册</title>
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
			<div class="well col-md-4 col-centered">
				<h3>个人备忘录</h3>
				<span class="msg"></span>
				<form action="" id="register-form" method="post" role="form" onsubmit="return confirm();">
					<div class="input-group input-group-md">
						<span class="input-group-addon"><i class="glyphicon glyphicon-user" aria-hidden="true"></i></span>
						<input type="text" class="form-control" id="nick" name="nick" placeholder="请输入昵称"/>
					</div>
					<span class="msg" id="nick-msg"></span>
					<div class="input-group input-group-md">
						<span class="input-group-addon"><i class="glyphicon glyphicon-user" aria-hidden="true"></i></span>
						<input type="text" class="form-control" id="username" name="username" placeholder="请输入账号"/>
					</div>
					<span class="msg" id="username-msg"></span>
					<div class="input-group input-group-md">
						<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
						<input type="password" class="form-control" id="password" name="password" placeholder="请输入密码"/>
					</div>
					<span class="msg"></span>
					<div class="input-group input-group-md">
						<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
						<input type="password" class="form-control" id="pwd" name="pwd" placeholder="再次输入密码"/>
					</div>
					<span class="msg" id="pwd-msg"></span>
					<br/>
					<button type="button" class="btn btn-success btn-block" id="register-btn">注册</button>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
<script src="/memo/js/jquery-1.11.0.min.js"></script>
<script src="/memo/js/bootstrap.min.js"></script>
<script>
    $(function () {
        $("#nick").blur(function() {
            if ($(this).val() == "") {
                $("#nick-msg").html("昵称不可为空");
			} else {
                $("#nick-msg").html("");
			}
		});
		$("#username").blur(function () {
		    if ($(this).val() == "") {
		        $("#username-msg").html("账号不能为空");
			} else {
                $.ajax({
					url:'/memo/user_check',
					type:'POST',
					data:{username:$('#username').val()},
                    dataType:'json',
                    success:function(data) {
                        if (data['status'] == 0) 
                            $("#username-msg").html("该账号已存在");
                        if (data['status'] == 1)
                            $("#username-msg").html("该账号可用");
                    },
                    error:function() {
                    }
				});
            }
        });
		$('#password').blur(function () {
			if ($(this).val() == "") {
			    $('#pwd-msg').html("密码不能为空");
			} else if ($(this).val() != $('#pwd').val()) {
			    $('#pwd-msg').html("两次密码不一致");
			} else {
			    $('#pwd-msg').html("");			
			}
        });
        $('#pwd').blur(function () {
            if ($(this).val() == "") {
                $('#pwd-msg').html("密码不能为空");
            } else if ($(this).val() != $('#password').val()) {
                $('#pwd-msg').html("两次密码不一致");
            } else {
                $('#pwd-msg').html("");
            }
        });
		$('#register-btn').click(function () {
			var formData = new FormData($('#register-form')[0]);
			$.ajax({
                url:'/memo/user_register',
                type:'POST',
                data:formData,
                processData: false,
                contentType:false,
                dataType:'json',
                success:function(data) {
                    if (data['status'] == 0) {
                        $('#nick').val(formData.get("nick"));
                        $('#username').val(formData.get("username"));
                    }
                    alert(data['msg']);
                    if (data['status'] == 1)
                        window.location.href='/memo/login.jsp';
                },
                error:function() {
                    alert("操作提交失败");
                    $('#nick').val(formData.get("nick"));
                    $('#username').val(formData.get("username"));
                }
			});
        });
    });
</script>
</html>