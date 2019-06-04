package com.lyq.struts.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;
/**
 * 批量删除Action类
 * 继承LookupDispatchAction类
 * @author Li Yong Qiang
 */
public class DeleteAction extends LookupDispatchAction{
	//用户身份验证
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//判断用户是否登录
		if(request.getSession().getAttribute("user") == null){
			return mapping.findForward("login");
		}
		return super.execute(mapping, form, request, response);
	}
	//重写LookupDispatchAction类的getKeyMethodMap()方法
	protected Map getKeyMethodMap() {
		Map map = new HashMap();
		//删除所选
		map.put("button.delete.selected", "selected");
		//删除全部
		map.put("button.delete.all", "all");
		return map;
	}
}
