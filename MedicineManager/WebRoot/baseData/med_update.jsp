<%@ page language="java" pageEncoding="GBK"%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html locale="true">
  <head>
    <title><bean:message key="medicine.update" /></title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="../images/styles.css">
	<script type="text/javascript">
		function save(){
			var form = document.forms["medForm"];
			if(form.elements["medCount"].value == "" || form.elements["medCount"].value <= 0){
				alert("<bean:message key="medicine.storage.count.null" />");
				form.elements["medCount"].focus();
				return false;
			}
			if(isNaN(form.elements["medCount"].value)){
				alert("<bean:message key="medicine.storage.count.format" />");
				form.elements["medCount"].focus();
				return false;
			}
		}
	</script>
  </head>
  <body>
   <div class="div1">
		<table width="100%" cellpadding="0" cellspacing="0" border="0"
			align="center">
			<tr>
				<td class="td_title1">
					¡¤<bean:message key="system.current.place"/>£º
					<bean:message key="system.category.medicine"/>
					&gt;&gt; <bean:message key="medicine.update" />
				</td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF" height="50">
					<br>
    <html:form action="baseData/med.do" method="post" focus="medCount" onsubmit="return save();">
    	<input type="hidden" name="command" value="update" />
    	<html:hidden property="id"/>
    	<html:hidden property="photoPath"/>
    	<html:hidden property="categoryId"/>
    	<html:hidden property="reqCount"/>
      <table border="0" align="center" width="450">
        <tr>
          <td align="right"><bean:message key="medicine.medNo" />£º</td>
          <td align="left"><html:text property="medNo" readonly="true"/></td>
        </tr>
        <tr>
          <td align="right"><bean:message key="medicine.name" />£º</td>
          <td align="left"><html:text property="name"  readonly="true"/></td>
        </tr>
        <tr>
          <td align="right"><bean:message key="medicine.price" />£º</td>
          <td align="left"><html:text property="price" readonly="true"/></td>
        </tr>
        <tr>
          <td align="right"><bean:message key="medicine.storage.count" />£º</td>
          <td align="left">
          	<html:text property="medCount" value=""/>
          	<font color="red">
          		<bean:message key="system.current" />£º
          		${medForm.medCount}
          	</font>
          </td>
        </tr>
        <tr>
          <td align="right"><bean:message key="medicine.factoryAdd" />£º</td>
          <td align="left"><html:textarea property="factoryAdd" cols="30" rows="3" readonly="true"></html:textarea></td>
        </tr>
        <tr>
          <td align="right"><bean:message key="medicine.description" />£º</td>
          <td align="left"><html:textarea property="description" cols="30" rows="3" readonly="true"></html:textarea></td>
        </tr>
        <tr>
          <td colspan="2" align="center"><html:submit><bean:message key="button.submit" /></html:submit></td>
        </tr>
      </table>
    </html:form>
    </td>
			</tr>
		</table>
	</div>
  </body>
</html:html>
