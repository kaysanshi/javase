<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type="text/javascript">
			var m = "";
			function menu(num){
				sub = eval("sub_"+num+".style");
				if(m != sub){
					if(m != ""){
						m.display = "none";
					}
					sub.display='block';
					m = sub;
				}else{
					sub.display = "none";
					m = "";
				}
			}
		</script>
		<link rel="stylesheet" type="text/css" href="images/styles.css">
	    <style type="text/css">
<!--
.m1 {
	font-size: 12px;
	font-weight: bold;
	margin-left: 60px;
	text-align: center;
	vertical-align: sub;
}
.sub1 {
	margin-left: 40px;
}
-->
        </style>
</head>
  <body>
    <table border="0" width="200" height="100%" align="right" cellSpacing="0" cellPadding="0" bgcolor="#E0FBC4">
    	<!-- 药品管理 -->
    	<tr>
			<td onClick="menu(0)" height="33" background="images/m1.jpg">
				<font class="m1">
					<bean:message key="system.category.medicine"/>
				</font>
			</td>
		</tr>
		<tr bgcolor="#E0FBC4">
			<td id="sub_0" style="display: none;">
				<table width="80%" align="center">
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="baseData/med_add.jsp" target="main" class="sub1"><bean:message key="system.category.medicine.add"/></a>
						</td>
					</tr>
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="baseData/med.do?command=paging" target="main" class="sub1">
								<bean:message key="system.category.medicine.view"/>
							</a>
						</td>
					</tr>
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="baseData/med_query.jsp" target="main" class="sub1"><bean:message key="system.category.medicine.query"/></a>
						</td>
					</tr>
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="baseData/med_count.jsp" target="main" class="sub1"><bean:message key="system.category.medicine.storage"/></a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
    	<!-- 类别管理 -->
    	<tr>
			<td onClick="menu(1)" height="33" background="images/m1.jpg">
				<font class="m1">
					<bean:message key="system.category.category"/>
				</font>
			</td>
		</tr>
		<tr bgcolor="#E0FBC4">
			<td id="sub_1" style="display: none">
				<table width="80%" align="center">
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="baseData/category_add.jsp" target="main" class="sub1"><bean:message key="system.category.category.add"/></a>
						</td>
					</tr>
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="baseData/category.do?command=paging" target="main" class="sub1"><bean:message key="system.category.category.view"/></a>
						</td>
					</tr>
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="baseData/category.do?command=findCategoryAndCound" target="main" class="sub1">
								<bean:message key="system.category.category.count"/>
							</a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<!-- 购买药品 -->
    	<tr>
			<td onClick="menu(2)" height="33" background="images/m1.jpg">
				<font class="m1">
				<bean:message key="system.category.buy"/>
				</font>
			</td>
		</tr>
		<tr bgcolor="#E0FBC4">
			<td id="sub_2" style="display: none">
				<table width="80%" align="center">
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="baseData/med.do?command=canSellMeds" target="main" class="sub1"><bean:message key="system.category.buy.buy"/></a>
						</td>
					</tr>
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="sell/sell.do?command=order" target="main" class="sub1"><bean:message key="system.category.buy.view"/></a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<!-- 销售管理 -->
    	<tr>
			<td onClick="menu(3)" height="33" background="images/m1.jpg">
				<font class="m1">
				<bean:message key="system.category.sell"/>
				</font>
			</td>
		</tr>
		<tr bgcolor="#E0FBC4">
			<td id="sub_3" style="display: none">
				<table width="80%" align="center">
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="sell/sell.do?command=paging" target="main" class="sub1"><bean:message key="system.category.sell.view"/></a>
						</td>
					</tr>
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="sell/sell.do?command=today" target="main" class="sub1"><bean:message key="system.category.sell.today"/></a>
						</td>
					</tr>
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="sell/sell_query.jsp" target="main" class="sub1"><bean:message key="system.category.sell.query"/></a>
						</td>
					</tr>
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="sell/sell.do?command=sequence" target="main" class="sub1"><bean:message key="system.category.sell.sep"/></a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<!-- 进货/需求管理 -->
    	<tr>
			<td onClick="menu(4)" height="33" background="images/m1.jpg">
				<font class="m1">
				<bean:message key="system.category.req"/>
				</font>
			</td>
		</tr>
		<tr bgcolor="#E0FBC4">
			<td id="sub_4" style="display: none">
				<table width="80%" align="center">
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="require/req_add.jsp" target="main" class="sub1"><bean:message key="system.category.req.add"/></a>
						</td>
					</tr>
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="require/require.do?command=paging" target="main" class="sub1"><bean:message key="system.category.req.view"/></a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	<!-- 系统管理 -->
    	<tr>
			<td onClick="menu(5)" height="33" background="images/m1.jpg">
				<font class="m1">
				<bean:message key="system.category.manage"/>
				</font>
			</td>
		</tr>
		<tr bgcolor="#E0FBC4">
			<td id="sub_5" style="display: none">
				<table width="80%" align="center">
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="system/user_add.jsp" target="main" class="sub1"><bean:message key="system.category.manage.user.add"/></a>
						</td>
					</tr>
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="system/system.do?command=userFind" target="main" class="sub1"><bean:message key="system.category.manage.user.view"/></a>
						</td>
					</tr>
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="system/user_password.jsp" target="main" class="sub1"><bean:message key="system.category.manage.user.modify"/></a>
						</td>
					</tr>
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="system/system.do?command=initialization" class="sub1" target="_top"><bean:message key="system.category.manage.init"/></a>
						</td>
					</tr>
					<tr>
						<td height="22" onmouseover="this.style.backgroundColor='#ffffff'" onmouseout="this.style.backgroundColor=''">
							<a href="system/system.do?command=userExit" target="_top" class="sub1"><bean:message key="system.category.manage.user.exit"/></a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td height="100%"></td>
		</tr>
	</table>
  </body>
</html>
