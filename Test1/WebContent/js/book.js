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
     {window.alert("��������Ϊ�գ�");
      document.form1.bookname.focus();
	  return false;
     }
if (document.form1.author.value=="")
     {window.alert("���߲���Ϊ�գ�");
      document.form1.author.focus();
	  return false;
     }
if (document.form1.press.value=="")
     {window.alert("�����粻��Ϊ�գ�");
      document.form1.press.focus();
	  return false;
     }
if (document.form1.price.value=="")
     {window.alert("�۸���Ϊ��");
      document.form1.price.focus();
	  return false;
     }
if(!isNum(document.form1.price.value))
     {window.alert("�۸����Ϊ��ֵ��");
      document.form1.price.focus();
	  return false;
     }
return true; 
}
