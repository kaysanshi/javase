<%@ page contentType="text/html; charset=GBK" %>
<html>
<head>
	<title>���۵����β˵�</title>
	<!-- ����dtree�������ʽ��dtree.css��js�ļ�dtree.js -->
	<link rel="stylesheet" href="dtree.css" type="text/css" />
	<script type="text/javascript" src="dtree.js"></script>
	<script>
		function ShowHideDiv(div,img){
			if(div.style.display == "none"){
				img.src="img/bookopen.png";
				div.style.display="block";
				img.title="�۵�";
			}else{
				img.src="img/book.png";
				div.style.display="none";
				img.title="չ��";
			}
		}
	</script>
</head>
<body>
<h2>���β˵�</h2>
<table width="180">
	<tr bgcolor="#F2F2F2">
		<td align="center" width="90%">
			<a href="#" onclick="javascript:ShowHideDiv(divTree,iImg);return false;">
				<b>�ҵ���Ŀ</b>
			</a>
		</td>
		<td align="right">
			<img src="img/bookopen.png" 
				onclick="javascript:ShowHideDiv(divTree,this)"
				title="�۵�" id="iImg" />
		</td>
	</tr>
	<tr><td colspan="2">
		<div class="dtree" id="divTree">
			<a href="javascript: d.openAll();">ȫ��չ��</a> | 
			<a href="javascript: d.closeAll();">ȫ���۵�</a><br/>
			<jsp:useBean id="tree" class="util.TreeUtil">
				<jsp:getProperty name="tree" property="treeNodes" />
			</jsp:useBean>
		</div>
	</td></tr>
</table>
</body>
</html>