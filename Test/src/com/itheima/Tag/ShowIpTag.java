package com.itheima.Tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class ShowIpTag implements Tag {
	private PageContext pc;
	//4.
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return 0;
	}
	//3.
	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		String  ip=pc.getRequest().getRemoteAddr();
		try {
			pc.getOut().write(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public Tag getParent() {
		// TODO Auto-generated method stub
		return null;
	}
	//5,�������ʱ��
	@Override
	public void release() {
		// TODO Auto-generated method stub

	}
	//���ȵ��õ�ǰ�Ķ���
	@Override
	public void setPageContext(PageContext arg0) {
		// TODO Auto-generated method stub
		this.pc=arg0;
	}
	//2,����ǩ�Ĵ���
	@Override
	public void setParent(Tag arg0) {
		// TODO Auto-generated method stub

	}

}
