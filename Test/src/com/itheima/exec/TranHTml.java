package com.itheima.exec;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TranHTml extends SimpleTagSupport{

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		StringWriter writer=new StringWriter();
		getJspBody().invoke(writer);
		String string=writer.toString();
		string = filter(string);
		getJspContext().getOut().write(string);
	}

	@Override
	protected JspFragment getJspBody() {
		// TODO Auto-generated method stub
		return super.getJspBody();
	}
	private String filter(String message) {
		if (message == null)
			return (null);

		char content[] = new char[message.length()];
		message.getChars(0, message.length(), content, 0);
		StringBuffer result = new StringBuffer(content.length + 50);
		for (int i = 0; i < content.length; i++) {
			switch (content[i]) {
			case '<':
				result.append("&lt;");
				break;
			case '>':
				result.append("&gt;");
				break;
			case '&':
				result.append("&amp;");
				break;
			case '"':
				result.append("&quot;");
				break;
			default:
				result.append(content[i]);
			}
		}
		return (result.toString());

	}
		
}
