package com.lyq.struts.action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
/**
 * 国际化Action类
 * @author Li Yong Qiang
 */
public class LanguageAction extends Action {
	//选择语言
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//获取所选择的语言类型
		String lan = request.getParameter("lan");
		if(lan != null){
			//本地语言
			Locale currentLocale = null;
			//zh代表中文，en代英文
			if("zh".equals(lan)){
				//创建中文Locale
				currentLocale = new Locale("zh", "CN");
			}else if("en".equals(lan)){
				//创建英文Locale
				currentLocale = new Locale("en", "US");
			}
			//将本地语言放入Struts的Globals.LOCALE_KEY中
			request.getSession().setAttribute(Globals.LOCALE_KEY, currentLocale);
		}
		//如果没有登录返回到登录页面，否则返回到管理页面
		if (request.getSession().getAttribute("user") == null) {
			return mapping.findForward("login");
		}else{
			return mapping.findForward("manage");
		}
	}
}
