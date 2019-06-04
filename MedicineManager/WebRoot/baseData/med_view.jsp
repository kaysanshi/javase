<%@ page language="java" pageEncoding="GBK"%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html locale="true">
  <head>
    <title><bean:message key="system.category.medicine.view" /></title>

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
					<bean:message key="system.category.medicine"/>
					&gt;&gt; <bean:message key="system.category.medicine.view" />
				</td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF" height="50">
					<br>
  	<logic:present name="med" scope="request">
  		<table border="1" align="center" width="700" cellpadding="1" cellspacing="1" bgcolor="#036500" bordercolor="#FFFFF">
       <tr bgcolor="#FFFFFF" >
          <td align="center" colspan="4" height="40">
			<html:link href="med.do?command=edit" paramId="id" paramName="med" paramProperty="id">
				<bean:message key="system.modify" />
			</html:link>
	        <html:link forward="buy" paramId="id" paramName="med" paramProperty="id">
				<bean:message key="system.buy" />
			</html:link>
		  </td>
		  <td rowspan="7" width="350" align="center" valign="middle">
				<logic:empty name="med" property="photoPath">
	          		<bean:message key="medicine.photo.null" />
	          	</logic:empty>
	          	<logic:notEmpty name="med" property="photoPath">
	          		<img src="../upload/<bean:write name='med' property='photoPath'/>" width="320"	height="220" />
	          	</logic:notEmpty>
		  </td>
        </tr>
        <tr bgcolor="#FFFFFF" >
          <td class="tb_tl2" align="right" width="70">ID£º</td>
          <td align="left"><bean:write name="med" property="id"/></td>
          <td class="tb_tl2" align="right" width="70"><bean:message key="medicine.medNo" />£º</td>
          <td align="left"><bean:write name="med" property="medNo"/></td>
        </tr>
        <tr bgcolor="#FFFFFF" >
          <td class="tb_tl2" align="right" width="70"><bean:message key="medicine.name" />£º</td>
          <td align="left" colspan="3"><bean:write name="med" property="name"/></td>
        </tr>
        <tr bgcolor="#FFFFFF" >
          <td class="tb_tl2" align="right" width="70"><bean:message key="medicine.storage.count" />£º</td>
          <td align="left"><bean:write name="med" property="medCount"/></td>
          <td class="tb_tl2" align="right" width="70"><bean:message key="medicine.req.count" />£º</td>
          <td align="left"><bean:write name="med" property="reqCount"/></td>
        </tr>
        <tr bgcolor="#FFFFFF" >
          <td class="tb_tl2" align="right" width="70"><bean:message key="medicine.price" />£º</td>
          <td align="left"><bean:write name="med" property="price"/></td>
          <td class="tb_tl2" align="right" width="70"><bean:message key="medicine.category" />£º</td>
          <td align="left"><bean:write name="med" property="category.name"/></td>
        </tr>
        <tr bgcolor="#FFFFFF" >
          <td class="tb_tl2" align="right" width="70"><bean:message key="medicine.factoryAdd" />£º</td>
          <td align="left" colspan="3"><bean:write name="med" property="factoryAdd"/></td>
        </tr>
        <tr bgcolor="#FFFFFF"  height="40">
          <td class="tb_tl2" align="right" width="70"><bean:message key="medicine.description" />£º</td>
          <td align="left" colspan="3"><bean:write name="med" property="description"/></td>
        </tr>
      </table>
  	</logic:present>
  	<logic:notPresent name="med" scope="request">
  		<bean:message key="system.message.null" />
  	</logic:notPresent>
  	<br>
      </td>
			</tr>
		</table>
	</div>
  </body>
</html:html>
