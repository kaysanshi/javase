<%@ page language="java" pageEncoding="GBK"%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html locale="true">
  <head>
    <title><bean:message key="sell.buyed"/></title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="../images/styles.css">
  </head>
  <body>
  <div class="div1">
		<table width="100%" cellpadding="0" cellspacing="0" border="0"
			align="center">
			<tr>
				<td class="td_title1">
					¡¤<bean:message key="system.current.place"/>£º
					<bean:message key="system.category.buy"/>
					&gt;&gt; <bean:message key="sell.buyed"/>
				</td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF" height="50">
					<br>
       <table border="1" align="center" width="600" cellpadding="1" cellspacing="1" bgcolor="#036500" bordercolor="#FFFFF">
        <tr bgcolor="#FFFFFF">
        	<td class="tb_tl"><bean:message key="medicine.name" /></td>
        	<td class="tb_tl"><bean:message key="medicine.price" /></td>
        	<td class="tb_tl"><bean:message key="system.count" /></td>
        	<td class="tb_tl"><bean:message key="sell.money" /></td>
        	<td class="tb_tl"><bean:message key="system.operate" /></td>
        </tr>
        <logic:present name="order" scope="session">
        	<logic:iterate id="ele" name="order" scope="session">
        		<tr bgcolor="#FFFFFF">
        		<td><bean:write name="ele" property="sellName"/></td>
        		<td><bean:write name="ele" property="sellPrice"/></td>
        		<td><bean:write name="ele" property="sellCount"/></td>
        		<td><bean:write name="ele" property="total" format="###,###.##"/>
       					<bean:message key="system.money"/>
				</td>
				<td>
					<html:link href="sell.do?command=deleteOrder" paramId="id" paramName="ele" paramProperty="id">
						<bean:message key="system.delete"/>
					</html:link>
				</td>
				</tr>
        	</logic:iterate>
        	<tr bgcolor="#FFFFFF">
        		<td colspan="5" align="center">
        			<html:link href="../baseData/med.do?command=canSellMeds"><bean:message key="system.goon"/></html:link>
        			<html:link href="sell.do?command=clear"><bean:message key="system.clear"/></html:link>
        			<html:link href="sell.do?command=buy"><bean:message key="sell.buy"/></html:link>
        			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        			<bean:message key="system.total"/>&nbsp;<bean:write name="sum" scope="session" format="###,###.##"/>&nbsp;
       					<bean:message key="system.money"/>
				</td>
        	</tr>
        </logic:present>
        <logic:notPresent name="order" scope="session">
        	<tr bgcolor="#FFFFFF">
        		<td colspan="5" align="center"><bean:message key="system.message.null"/></td>
        	</tr>
        </logic:notPresent>
      </table>
      <br>
      </td>
			</tr>
		</table>
	</div>
  </body>
</html:html>
