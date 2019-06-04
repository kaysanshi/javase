<%@ page pageEncoding="GBK" %>
<%@ include file="/header.jsp" %>
<script>
   function check(){
      name=document.f.name.value;
      file=document.f.file.value;
      if(name==""){
         alert("软件名称不能为空！");
         return false;
      }else if(file==""){
         alert("请选择要上传的软件！");
         return false;
      }else{
         return true;
      }
   }
</script>
<form method="post" action="${pageContext.request.contextPath}/as/add" enctype="multipart/form-data" name="f" onSubmit="return check()">
      <div align="center">
            <h2>文件添加</h2>
            <table border="0" cellspacing="1" width="60%">
              <tr> 
                <td width="20%" align="right" bgcolor="#CCCCCC"><b>文件说明</b></td>
                <td bgcolor="#CCCCCC"> 
                  <input type="text" name="name" size="50">
                </td>
              </tr>
              <tr> 
                <td align="right" bgcolor="#CCCCCC"><b>文件类型</b></td>
                <td bgcolor="#CCCCCC"> 
                  <select name="type">
                      <option value="1">图片</option>
                      <option value="2">Flash</option>
                      <option value="3">音乐</option>
                      <option value="4">小视频</option>
                      <option value="5">其他</option>
                  </select>
                </td>
              </tr>
              <tr> 
                <td align="right" bgcolor="#CCCCCC"><b>详细描述</b></td>
                <td bgcolor="#CCCCCC"> 
                  <textarea rows="6" name="description" cols="50"></textarea>
                </td>
              </tr>
              <tr>
                <td align="right" bgcolor="#CCCCCC"><b>文件上传</b></td>
                <td bgcolor="#CCCCCC"> 
                  <input type="file" name="file">
                </td>
              </tr>
            </table>
       </div>
       <div align="center">
            <p> 
               <input type="submit" value="提交">
               <input type="reset" value="重填">
            </p>
       </div>
</form>