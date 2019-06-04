package com.lyq.struts.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.lyq.dao.UserDao;
import com.lyq.persistence.User;
import com.lyq.struts.form.UserForm;
/**
 * 系统Action类
 * @author Li Yong Qiang
 */
public class SystemAction extends BaseAction {
	
	//如果没有传递参数默认调用此方法
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward forword = new ActionForward("/login.jsp", true);
		return forword;
	}
	
	// 用户退出
	public ActionForward userExit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.getSession().removeAttribute("user");
		return mapping.findForward("login");
	}

	// 添加用户
	public ActionForward userAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm uf = (UserForm) form;
		if (uf != null) {
			//密码是否与确认密码相等则添加用户信息
			if(uf.getPassword().equals(uf.getRePassword())){
				User user = new User();	// 实例化一个User对象
				BeanUtils.copyProperties(user, uf);	// 对user属性赋值
				user.setCreateTime(new Date());		// 对创建时间属性赋值
				UserDao dao = new UserDao();		// 实例化UserDao对象
				dao.save(user);	// 保存user对象
			}
		}
		return mapping.findForward("userFind");
	}

	// 查找所有用户
	public ActionForward userFind(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserDao dao = new UserDao();
		List list = dao.findByHQL("from User");
		if (list != null) {
			request.setAttribute("list", list);
		}
		return mapping.findForward("findAllSuccess");
	}

	// 删除用户
	public ActionForward userDelete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm uf = (UserForm) form;
		if (uf.getId() > 0) {
			//从session之中获取User对象
			User u = (User) request.getSession().getAttribute("user");
			if (u != null) {
				//用户不能删除自身账号
				if (uf.getId() != u.getId()) {
					UserDao dao = new UserDao();
					dao.deleteByHQL("delete from User u where u.id = " + uf.getId());
				}else{
					//删除自身返回错误信息
					ActionMessages errors = new ActionMessages();
					errors.add("",new ActionMessage("user.delete.error"));
					this.saveErrors(request, errors);
					return mapping.findForward("error");
				}
			}
		}
		return mapping.findForward("userFind");
	}

	// 编辑用户
	public ActionForward userEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserForm uf = (UserForm) form;
		if (uf.getId() > 0) {
			UserDao dao = new UserDao();
			User user = dao.loadUser(uf.getId());
			BeanUtils.copyProperties(uf, user);
		}
		return mapping.findForward("userEdit");
	}

	// 修改密码
	public ActionForward modifyPassword(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm uf = (UserForm) form;
		if (uf != null) {
			//从session之中获取User对象
			User user = (User) request.getSession().getAttribute("user");
			//确认两次密码是否一致
			if (user != null && uf.getOldPassword().equals(user.getPassword())) {
				if (uf.getPassword().equals(uf.getRePassword())) {
					UserDao dao = new UserDao();
					user.setPassword(uf.getPassword());
					dao.saveOrUpdate(user);
				}
			}else{
				//密码错误
				ActionMessages errors = new ActionMessages();
				errors.add("",new ActionMessage("user.oldpassword.error"));
				this.saveErrors(request, errors);
				return mapping.findForward("error");
			}
		}
		return mapping.findForward("userFind");
	}
	//初始化
	public ActionForward initialization(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserDao dao = new UserDao();
		//初始化数据
		dao.initialization();
		request.getSession().invalidate();
		ActionForward forward = new ActionForward("/login.jsp",true);
		return forward;
	}
	
	
}
