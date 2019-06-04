<%@ page contentType="text/html; charset=GBK" %>
<html>
   <head>
    <title>dtree sample动态树形菜单</title>
    <!-- 导入dtree组件的样式表dtree.css和js文件dtree.js -->
    <link rel="stylesheet" href="dtree.css" type="text/css" />
	<script type="text/javascript" src="dtree.js"></script>
  </head>
  <body>
    <div class="dtree">
	<a href="javascript: d.openAll();">全部展开</a> | 
	<a href="javascript: d.closeAll();">全部折叠</a><br/>
	<jsp:useBean id="tree" class="util.TreeUtil">
		<jsp:getProperty name="tree" property="treeNodes" />
	</jsp:useBean>
	</div>
 </body>
</html>