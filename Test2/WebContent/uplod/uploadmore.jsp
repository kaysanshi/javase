<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function addone(){
		var fdiv=document.getElementById("fdiv");
		fdiv.innerHTML+='<div><input type="file" name="file1"/><input type="button" value="删去" onclick="delone(this)"><br></div>';
	}
function delone(obj){
	obj.parentNode.parentNode.removeChild(obj.parentNode);
}
</script>
</head>
<body>
	<input type="button" id="addBut" onclick="addone()"value="加一个">
<form action="${pageContext.request.contextPath }/UploadServlet"method="Post" enctype="multipart/form-data">
	<div id="fdiv"></div>
	
	<input type="submit" value="上传">
	</form>
</body>
</html>