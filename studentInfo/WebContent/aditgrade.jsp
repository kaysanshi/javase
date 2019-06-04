<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生成绩的增加</title>
<script>
		function addgrade(){
			var sno=document.getElementById("sno");
			if(sno.value==""|| sno.value==null){
				alert("请输入学号");
				sno.focus();
				return null;
			}
			var name=document.getElementById("name");
			if(name.value==""|| name.value==null){
				alert("请输入姓名");
				sno.focus();
				return false;
			}
			var course=document.getElementById("course");
			if(course.value==""|| course.value==null){
				alert("请输入课程");
				return false;
			}
			var score=document.getElementById("score");
			if(score.value=="" || score.value==null){
				alert("请输入成绩");
			}
			var teacher=document.getElementById("teacher");
			if(teacher.value==""|| teacher.value==null){
				alert("请输入教师");
				return false;
			}
			//用超链接提交表单；
			document.getElementById("addform").submit();
		}
</script>
</head>
<body>
	<form  id="addform" action="savegrade.jsp" method="post">
	<h2>成绩录入</h2><br/>
	学号：<input id="sno" type="text" name="sno"/><br/>
	姓名：<input id="name" type="text" name="name"/><br/>
	专业：<select name="major">			
				<option  value="网络工程" >网络工程</option>
				<option  value="网络工程">网络工程</option>
				<option value="网络工程">网络工程</option>
				<option value="网络工程">网络工程</option>
				<option value="网络工程">网络工程</option>
		</select><br/>
	课程：<input id="course"type="text" name="course"/><br/>
	分数：<input id="score" type="text" name="score"/><br/>
	教师：<input id="teach"type="text" name="teacher"/><br/>
	<input type="submit" value="添加" onclick="addgrade()"/>	
	</form>
</body>
</html>