<%@ page pageEncoding="GBK" %>
<%@ include file="/header.jsp" %>
<script>
   function check(){
      name=document.f.name.value;
      file=document.f.file.value;
      if(name==""){
         alert("������Ʋ���Ϊ�գ�");
         return false;
      }else if(file==""){
         alert("��ѡ��Ҫ�ϴ��������");
         return false;
      }else{
         return true;
      }
   }
</script>
<form method="post" action="${pageContext.request.contextPath}/as/add" enctype="multipart/form-data" name="f" onSubmit="return check()">
      <div align="center">
            <h2>�ļ����</h2>
            <table border="0" cellspacing="1" width="60%">
              <tr> 
                <td width="20%" align="right" bgcolor="#CCCCCC"><b>�ļ�˵��</b></td>
                <td bgcolor="#CCCCCC"> 
                  <input type="text" name="name" size="50">
                </td>
              </tr>
              <tr> 
                <td align="right" bgcolor="#CCCCCC"><b>�ļ�����</b></td>
                <td bgcolor="#CCCCCC"> 
                  <select name="type">
                      <option value="1">ͼƬ</option>
                      <option value="2">Flash</option>
                      <option value="3">����</option>
                      <option value="4">С��Ƶ</option>
                      <option value="5">����</option>
                  </select>
                </td>
              </tr>
              <tr> 
                <td align="right" bgcolor="#CCCCCC"><b>��ϸ����</b></td>
                <td bgcolor="#CCCCCC"> 
                  <textarea rows="6" name="description" cols="50"></textarea>
                </td>
              </tr>
              <tr>
                <td align="right" bgcolor="#CCCCCC"><b>�ļ��ϴ�</b></td>
                <td bgcolor="#CCCCCC"> 
                  <input type="file" name="file">
                </td>
              </tr>
            </table>
       </div>
       <div align="center">
            <p> 
               <input type="submit" value="�ύ">
               <input type="reset" value="����">
            </p>
       </div>
</form>