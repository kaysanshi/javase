package com.lyq.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.lyq.dao.MedicineDao;
import com.lyq.util.StringUtil;
/**
 * 药品批量删除Action类
 * LookupDispatchAction的子类
 * @author Li Yong Qiang
 */
public class DeleteMedicineAction extends DeleteAction {
	MedicineDao dao = new MedicineDao();
	//删除全部
	public ActionForward all(ActionMapping arg0, ActionForm arg1,
			HttpServletRequest arg2, HttpServletResponse arg3) throws Exception {
		// 获取药品id
		String[] ids = arg2.getParameterValues("allId");
		// 有效性验证
		if(ids != null && ids.length > 0){
			// 删除全部
			dao.deleteByHQL("delete Medicine d where d.id in("+StringUtil.arr2Str(ids)+")");
		}
		return arg0.findForward("findAllSuccess");
	}
	//删除所选
	public ActionForward selected(ActionMapping arg0, ActionForm arg1,
			HttpServletRequest arg2, HttpServletResponse arg3) throws Exception {
		// 获取药品id
		String[] ids = arg2.getParameterValues("selectedId");
		// 有效性验证
		if(ids != null && ids.length > 0){
			// 删除所选
			dao.deleteByHQL("delete Medicine d where d.id in("+StringUtil.arr2Str(ids)+")");
		}
		return arg0.findForward("findAllSuccess");
	}
}
