function isNum(num){
   for(i=0;i<num.length;i++){
       c=num.charAt(i);
       if(c!='.' && (c>'9' || c<'0'))
           return false;
   }
   return true;
}
function check(){
if (document.form1.bookname.value=="")
     {window.alert("书名不能为空！");
      document.form1.bookname.focus();
	  return false;
     }
if (document.form1.author.value=="")
     {window.alert("作者不能为空！");
      document.form1.author.focus();
	  return false;
     }
if (document.form1.press.value=="")
     {window.alert("出版社不能为空！");
      document.form1.press.focus();
	  return false;
     }
if (document.form1.price.value=="")
     {window.alert("价格不能为空");
      document.form1.price.focus();
	  return false;
     }
if(!isNum(document.form1.price.value))
     {window.alert("价格必须为数值！");
      document.form1.price.focus();
	  return false;
     }
return true; 
}
