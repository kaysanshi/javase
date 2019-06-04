package com.itheima.exec;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class RefTag extends SimpleTagSupport{

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		//jspContext();jsp“≥√Êµƒ”Ú
		PageContext pc = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pc.getRequest();
		HttpServletResponse response = (HttpServletResponse) pc.getResponse();
		String ref = request.getHeader("Referer");
  		if(ref == null || "".equals(ref) || !ref.startsWith("http://localhost")){
  			response.sendRedirect(request.getContextPath()+"/index.jsp");
  			return;
  		}
	}

}
