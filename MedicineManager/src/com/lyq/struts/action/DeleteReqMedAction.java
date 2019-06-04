package com.lyq.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.lyq.dao.MedicineDao;
import com.lyq.util.StringUtil;
/**
 * 批量删除药品需求信息Action类
 * LookupDispatchAction的子类
 * @author Li Yong Qiang
 */
public class DeleteReqMedAction extends DeleteAction{
	MedicineDao dao = new MedicineDao();
	//删除全部
	public ActionForward all(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[] ids = request.getParameterValues("allId");
		if(ids != null && ids.length > 0){
			dao.deleteByHQL("update Medicine d set d.reqCount=0 where d.id in("+StringUtil.arr2Str(ids)+")");
		}
		return mapping.findForward("findAllSuccess");
	}
	//删除所选
	public ActionForward selected(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[] ids = request.getParameterValues("selectedId");
		if(ids != null && ids.length > 0){
			dao.deleteByHQL("update Medicine d set d.reqCount=0 where d.id in("+StringUtil.arr2Str(ids)+")");
		}
		return mapping.findForward("findAllSuccess");
	}
}
