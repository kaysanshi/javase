<%@ page contentType="text/html; charset=GBK" %>
<html>
<head>
	<title>可折叠树形菜单</title>
	<!-- 导入dtree组件的样式表dtree.css和js文件dtree.js -->
	<link rel="stylesheet" href="dtree.css" type="text/css" />
	<script type="text/javascript" src="dtree.js"></script>
	<script>
		function ShowHideDiv(div,img){
			if(div.style.display == "none"){
				img.src="img/bookopen.png";
				div.style.display="block";
				img.title="折叠";
			}else{
				img.src="img/book.png";
				div.style.display="none";
				img.title="展开";
			}
		}
	</script>
</head>
<body>
<h2>树形菜单</h2>
<table width="180">
	<tr bgcolor="#F2F2F2">
		<td align="center" width="90%">
			<a href="#" onclick="javascript:ShowHideDiv(divTree,iImg);return false;">
				<b>我的栏目</b>
			</a>
		</td>
		<td align="right">
			<img src="img/bookopen.png" 
				onclick="javascript:ShowHideDiv(divTree,this)"
				title="折叠" id="iImg" />
		</td>
	</tr>
	<tr><td colspan="2">
		<div class="dtree" id="divTree">
			<a href="javascript: d.openAll();">全部展开</a> | 
			<a href="javascript: d.closeAll();">全部折叠</a><br/>
			<jsp:useBean id="tree" class="util.TreeUtil">
				<jsp:getProperty name="tree" property="treeNodes" />
			</jsp:useBean>
		</div>
	</td></tr>
</table>
</body>
</html>