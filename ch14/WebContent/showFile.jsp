<%@ page pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/header.jsp"%>
<center>
	<h2>
		�ļ���ϸ��Ϣ
	</h2>
	<table border width="70%">
		<tr>
			<td bgcolor="#CCCCCC" width="15%">
				�ļ�˵��
			</td>
			<td width="45%">
				${file.name}
			</td>
			<td bgcolor="#CCCCCC" width="15%">
				�ļ���С
			</td>
			<td>
				${file.size}�ֽ�
			</td>
		</tr>
		<tr>
			<td bgcolor="#CCCCCC" width="15%">
				��������
			</td>
			<td width="45%">
				${file.lastModified}
			</td>
			<td bgcolor="#CCCCCC" width="15%">
				���ش���
			</td>
			<td>
				${file.hits}
			</td>
		</tr>
		<tr>
			<td bgcolor="#CCCCCC" width="15%">
				��ϸ����
			</td>
			<td colspan="3">
				${file.description}
			</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<a href="${pageContext.request.contextPath}/dls?id=${file.id}">
				����
				</a>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/us/top">
				����
				</a>
			</td>
		</tr>
	</table>
</center>