package com.itheima.Tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class SimpleShowIp implements SimpleTag {
	private  JspContext pc=null;
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		PageContext pageContext=(PageContext)pc;
		String  ip=pageContext.getRequest().getRemoteAddr();
		pageContext.getOut().write(ip);
	}

	@Override
	public JspTag getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setJspBody(JspFragment arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setJspContext(JspContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setParent(JspTag arg0) {
		// TODO Auto-generated method stub

	}

}
