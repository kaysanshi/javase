package com.lyq.struts.action;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.util.MessageResources;

import com.lyq.dao.SupperDao;

/**
 * 用于继承，处理用户是否登录及分页
 * 
 * @author Li Yong Qiang
 */
public class BaseAction extends DispatchAction {

	protected int recPerPage = 3; // 分页中每页的记录数
	protected Locale locale = null; // 本地语言信息
	protected MessageResources message = null;// 消息资源

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 获取Locale信息
		this.locale = this.getLocale(request);
		// 获取消息资源对象
		this.message = this.getResources(request);
		// 如果用户没有登录，跳转到登录页面
		if (request.getSession().getAttribute("user") == null) {
			return mapping.findForward("login");
		}
		return super.execute(mapping, form, request, response);
	}

	/**
	 * 分页
	 * @param hql hql语句（不包含select,从from子句开始）
	 * @param recPerPage 每页的记录数
	 * @param currPage 当前页码
	 * @param action 请求提交的action地址
	 * @param where 条件数组
	 * @return Map集合(装载结果集对象及分页条)
	 */
	public Map getPage(String hql, int recPerPage, String currPage,
			String action, Object[] where) {
		// 实例化一个Map对象
		Map map = new HashMap();
		// 分页条
		StringBuffer pagingBar = new StringBuffer();
		List list = null; // 结果集
		int iCurrPage = 1; // 当前页码
		// 如果传递了页码则对当前页码赋值
		if (currPage != null && !currPage.isEmpty()) {
			iCurrPage = Integer.parseInt(currPage);
		}
		// 实例化SupperDao对象
		SupperDao dao = new SupperDao();
		int pages = 0; // 总页数
		// 获取总记录数
		Long l = (Long) dao.uniqueResult("select count(*) " + hql, where);
		int count = l.intValue(); // 将总记录数转为int型
		if (count > 0) {
			// 计算总页数
			if (count % recPerPage == 0) {
				pages = count / recPerPage;
			} else {
				pages = count / recPerPage + 1;
			}
			if (iCurrPage > pages) {
				iCurrPage = pages;
			}
			if (iCurrPage < 1) {
				iCurrPage = 1;
			}
			// 分页查询获取结果集
			list = dao.findPaging(hql, (iCurrPage - 1) * recPerPage,
					recPerPage, where);
			// 构造分页条
			pagingBar.append("<form name='pagingForm' action='" + action
					+ "' method='post'>");
			// 在分页条中添加总记录数
			pagingBar.append(message.getMessage(locale, "page.totalRecord")
					+ count);
			pagingBar.append("   ");
			pagingBar.append(message.getMessage(locale, "system.total") + "  "
					+ pages + "  " + message.getMessage(locale, "page.page"));
			pagingBar.append("   ");
			// 页数大于1显示上一页超链接，否则不显示超链接
			if (iCurrPage > 1) {
				pagingBar.append("<a href=" + action + "&currPage=1>"
						+ message.getMessage(locale, "page.first") + "</a>");
				pagingBar.append("   ");
				pagingBar.append("<a href=" + action + "&currPage="
						+ (iCurrPage - 1) + ">"
						+ message.getMessage(locale, "page.previous") + "</a>");
				pagingBar.append("   ");
			} else {
				pagingBar.append(message.getMessage(locale, "page.first"));
				pagingBar.append("   ");
				pagingBar.append(message.getMessage(locale, "page.previous"));
				pagingBar.append("   ");
			}
			// 显示当前页码
			pagingBar.append("<font color='red'>" + iCurrPage + "</font>");
			pagingBar.append("   ");
			// 页数小于总页数显示下一页超链接，否则不显示超链接
			if (iCurrPage < pages) {
				pagingBar.append("<a href=" + action + "&currPage="
						+ (iCurrPage + 1) + ">"
						+ message.getMessage(locale, "page.next") + "</a>");
				pagingBar.append("   ");
				pagingBar.append("<a href=" + action + "&currPage=" + pages
						+ ">" + message.getMessage(locale, "page.last")
						+ "</a>");
			} else {
				pagingBar.append(message.getMessage(locale, "page.next"));
				pagingBar.append("   ");
				pagingBar.append(message.getMessage(locale, "page.last"));
			}
			pagingBar.append("   ");
			pagingBar.append("<input type='text' name='currPage' size='1'>");
			pagingBar.append("<input type='submit' value='GO'>");
			pagingBar.append("</form>");
		}
		map.put("list", list);// 结果集
		map.put("bar", pagingBar.toString());// 分页条的字符串形式
		return map;
	}
}
