<%@ page contentType="text/html; charset=GBK" %>
<html>
   <head>
    <title>dtree sample��̬���β˵�</title>
    <!-- ����dtree�������ʽ��dtree.css��js�ļ�dtree.js -->
    <link rel="stylesheet" href="dtree.css" type="text/css" />
	<script type="text/javascript" src="dtree.js"></script>
  </head>
  <body>
    <div class="dtree">
	<a href="javascript: d.openAll();">ȫ��չ��</a> | 
	<a href="javascript: d.closeAll();">ȫ���۵�</a><br/>
	<jsp:useBean id="tree" class="util.TreeUtil">
		<jsp:getProperty name="tree" property="treeNodes" />
	</jsp:useBean>
	</div>
 </body>
</html>