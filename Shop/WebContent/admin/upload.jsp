<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<c:url value='/admin/css/style.css'/>" rel="stylesheet" type="text/css" />
<link href="<c:url value='/admin/css/select.css'/> " rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<c:url value='/admin/js/jquery.js'/> "></script>
<script type="text/javascript" src="<c:url value='/admin/js/select-ui.min.js'/> "></script>
<script type="text/javascript">
	$(function(){
		$("#sure").click(function(){
			var path = $("#path").val();
			$("#filepath",window.opener.document).val(path);
			$("#img1",window.opener.document).attr("src", <c:url value='/'/> +path+"?t="+Math.random());
			window.close();
		});
		
	});
</script>
</head>

<body>

	
	    <form action="<c:url value='/imageUploadServlet'/> " method="post" enctype="multipart/form-data">
		<input type="hidden" value="${path }" id="path"/>
		<div class="formbody">
			<div class="formtitle">
				<span>上传</span>
			</div>
			<ul class="forminfo">
				
					<li></li>
					<li><label>文件</label>
					<div class="vocation">
						<input name="imgpath" type="file" class="dfinput" style="width:200px;" />
						<input  type="submit" class="btn" value="上传"/>
					</div></li>
					<li><label style="color:red;width:278px;" id="result">&nbsp;</label></li>
				<li><label>&nbsp;</label>
				&nbsp;&nbsp;
				<input  type="button" class="btn" id="sure" value="确定"/>
				</li>
			</ul>

		</div>
	</form>
</body>
</html>
