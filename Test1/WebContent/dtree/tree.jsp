<%@ page contentType="text/html;charset=GBK" %>
<html>
  <head>
    <title>dtree sample</title>
    <!-- ����dtree�������ʽ��dtree.css��js�ļ�dtree.js -->
    <link rel="stylesheet" href="dtree.css" type="text/css" />
	<script type="text/javascript" src="dtree.js"></script>
  </head>
  <body>
  <div class="dtree">
    <h2>���β˵�dtree��������Ӿ�̬</h2>
    <p><a href="javascript:d.openAll();">ȫ��չ��</a> | 
    <a href="javascript:d.closeAll();">ȫ���۵�</a></p>
    <script type="text/javascript">
		d = new dTree('d');
		d.add(0,-1,'�ҵ����β˵�');
		d.add(1,0,'�ڵ�1','tree.jsp');
		d.add(2,0,'�ڵ�2','tree.jsp');
		d.add(3,1,'�ڵ�1.1','tree.jsp');
		d.add(4,0,'�ڵ�3','tree.jsp');
		d.add(5,3,'�ڵ�1.1.1','tree.jsp');
		d.add(6,5,'�ڵ�1.1.1.1','tree.jsp');
		d.add(7,0,'�ڵ�4','tree.jsp');
		d.add(8,1,'�ڵ�1.2','tree.jsp');
		d.add(9,0,'�ҵ����','tree.jsp','�����ҵ����','','','img/imgfolder.gif');
		d.add(10,9,'�ҵ�����','tree.jsp','�ҵ�������Ƭ');
		d.add(11,9,'��������','tree.jsp');
		d.add(12,0,'����վ','tree.jsp','','','img/trash.gif');
		document.write(d);
	</script>
</div>
</body>
</html>