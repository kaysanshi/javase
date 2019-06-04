package com.lyq.struts.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.lyq.dao.MedicineDao;
import com.lyq.dao.SellDao;
import com.lyq.persistence.Medicine;
import com.lyq.persistence.SellDetail;
import com.lyq.persistence.User;
import com.lyq.struts.form.SellDetailForm;
/**
 * 销售Action类
 * @author Li Yong Qiang
 */
public class SellAction extends BaseAction {
	//向购物车中添加药品
	public ActionForward order(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//获取SellDetailForm
		SellDetailForm sdf = (SellDetailForm) form;
		if (sdf != null && sdf.getSellPrice() > 0 && sdf.getMedId() > 0) {
			MedicineDao medDao = new MedicineDao();
			//加载药品信息
			Medicine med = medDao.loadMedicine(sdf.getMedId());
			//如果购买的数量小于库存数量，进行错误处理
			if (med.getMedCount() < sdf.getSellCount()) {
				ActionMessages errors = new ActionMessages();
				ActionMessage message = new ActionMessage("drug.drugCount.error", "");
				errors.add("", message);
				this.saveErrors(request, errors);
				return mapping.findForward("error");
			}
			sdf.setSellTime(new Date());	
			//计算总价
			double sum = sdf.getSellPrice() * sdf.getSellCount();
			sdf.setTotal(sum);
			HttpSession session = request.getSession();
			// 获取订单
			List list = (List) session.getAttribute("order");
			List meds = new ArrayList();	// 实例化一个List对象
			if (list == null) {
				sdf.setId(1);
			} else {
				int i = 1;
				// 迭代已添加的药品
				for (; i <= list.size(); i++) {
					SellDetailForm temp = (SellDetailForm) list.get(i - 1);
					temp.setId(i);
					sum += temp.getTotal();	//计算总价格
					meds.add(temp);
				}
				sdf.setId(i);
			}
			meds.add(sdf);
			// 将总价保存到session之中
			session.setAttribute("sum", new Double(sum));
			// 将新的订单保存到session之中
			session.setAttribute("order", meds);
		}
		return mapping.findForward("order");
	}

	//选购药品
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SellDetailForm sdf = (SellDetailForm) form;
		if (sdf.getId() > 0) {
			MedicineDao medDao = new MedicineDao();
			Medicine med = medDao.loadMedicine(sdf.getId());
			sdf.setMedId(med.getId());
			sdf.setSellName(med.getName());
			sdf.setSellPrice(med.getPrice());
			sdf.setSellCount(1);
			sdf.setFactoryAdd(med.getFactoryAdd());
		}
		return mapping.findForward("add");
	}

	//结账购物车中的药品
	public ActionForward buy(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		//获取购物车中所有药品
		List list = (List) session.getAttribute("order");
		if (list != null && list.size() > 0) {
			try {
				SellDao dao = new SellDao();
				MedicineDao medDao = new MedicineDao();
				//获取当前操作员（用户）
				User user = (User) request.getSession().getAttribute("user");
				//通过循环进行结账
				for (int i = 0; i < list.size(); i++) {
					SellDetailForm sdf = (SellDetailForm) list.get(i);
					//加载药品信息
					Medicine med = medDao.loadMedicine(sdf.getMedId());
					int dCount = med.getMedCount();
					int sCount = sdf.getSellCount();
					//如果库存中数量足够，进行结账，否则进行错误处理
					if (dCount >= sCount) {
						SellDetail sd = new SellDetail();
						sd.setSellCount(sdf.getSellCount());
						sd.setSellName(sdf.getSellName());
						sd.setSellPrice(sdf.getSellPrice());
						sd.setSellTime(new Date());
						sd.setMed(med);
						sd.setUser(user);
						//保存销售明细
						dao.saveSellDetail(sd);
						//更新库库存信息
						med.setMedCount(dCount - sCount);
						medDao.saveOrUpdate(med);
					} else {
						ActionMessages errors = new ActionMessages();
						ActionMessage message = new ActionMessage(
								"drug.drugCount.error", "");
						errors.add("", message);
						this.saveErrors(request, errors);
						return mapping.findForward("error");
					}
				}
			} finally {
				session.removeAttribute("order");
				session.removeAttribute("sum");
			}
		}
		return mapping.findForward("paging");
	}

	//分页查询销售明细
	public ActionForward paging(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//获取当前页码
		String currPage = request.getParameter("currPage");
		String action = request.getContextPath()
				+ "/sell/sell.do?command=paging";
		String hql = "from SellDetail s order by s.sellTime desc";
		//分页查询
		Map map = this.getPage(hql, recPerPage, currPage, action, null);
		//将结果集放到request中
		request.setAttribute("list", map.get("list"));
		//将结果集放到分页条中
		request.setAttribute("pagingBar", map.get("bar"));
		return mapping.findForward("findAllSuccess");
	}

	//删除购物车中指定的药品
	public ActionForward deleteOrder(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//获取id
		String id = request.getParameter("id");
		if (id != null && !id.isEmpty()) {
			HttpSession session = request.getSession();
			//获取购物车
			List order = (List) session.getAttribute("order");
			List list = null;
			if (order != null) {
				//获取总额
				double sum = ((Double) session.getAttribute("sum"))
						.doubleValue();
				//创建新的购物车对象
				list = new ArrayList();
				for (int i = 0; i < order.size(); i++) {
					SellDetailForm sdf = (SellDetailForm) order.get(i);
					if (!id.equals(String.valueOf(sdf.getId()))) {
						list.add(sdf);
					} else {
						sum -= sdf.getTotal();
					}
				}
				session.setAttribute("order", list);
				session.setAttribute("sum", new Double(sum));
			}
		}
		return mapping.findForward("order");
	}

	//模糊查询，分页显示
	public ActionForward blurQuery(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//获取关键词
		String keyWord = request.getParameter("keyWord");
		String action = request.getContextPath()
				+ "/sell/sell.do?command=blurQuery";
		//HQL查询语句
		String hql = "from SellDetail s";
		//获取当前页码
		String currPage = request.getParameter("currPage");
		Object[] where = null;
		// 转码
		if (currPage != null && !currPage.isEmpty()) {
			keyWord = new String(keyWord.getBytes("iso-8859-1"), "gbk");
		}
		if (keyWord != null && !keyWord.isEmpty()) {
			action += "&keyWord=" + keyWord;
			keyWord = "%" + keyWord + "%";
			hql += " where s.sellName like ?";
			where = new Object[] { keyWord };
		}
		//分页查询
		Map map = this.getPage(hql, recPerPage, currPage, action, where);
		//将结果集放到request中
		request.setAttribute("list", map.get("list"));
		//将结果集放到分页条中
		request.setAttribute("pagingBar", map.get("bar"));
		return mapping.findForward("findAllSuccess");
	}

	// 清空订单
	public ActionForward clear(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("sum");
		session.removeAttribute("order");
		return mapping.findForward("order");
	}

	// 查询指定时间段的销售明细
	public ActionForward today(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//获取当前页码
		String currPage = request.getParameter("currPage");
		String action = request.getContextPath() + "/sell/sell.do?command=today";
		String begin = request.getParameter("begin");	// 起始时间
		String end = request.getParameter("end");		// 结束时间
		// 查询当天
		SimpleDateFormat sdf = null;
		if (begin == null || begin.isEmpty() || end == null || end.isEmpty()) {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(new Date());
			begin = date;
			end = date;
		}
		action += "&begin=" + begin + "&end=" + end;
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		begin += " 00:00:00";
		end += " 23:59:59";
		//分页查询
		Object[] where = new Object[] { sdf.parse(begin), sdf.parse(end) };
		String hql = "from SellDetail s where s.sellTime between ? and ?";
		Map map = this.getPage(hql, recPerPage, currPage, action, where);
		//将结果集放到request中
		request.setAttribute("list", map.get("list"));
		//将结果集放到分页条中
		request.setAttribute("pagingBar", map.get("bar"));
		return mapping.findForward("findAllSuccess");
	}

	// 销售排行
	public ActionForward sequence(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SellDao dao = new SellDao();
		List list = dao.sellSeq();
		if (list != null && list.size() > 0) {
			request.setAttribute("list", list);
		}
		return mapping.findForward("sequence");
	}

	// 根据销售药品id查询销售信息
	public ActionForward findByMedId(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("id");
		//获取当前页码
		String currPage = request.getParameter("currPage");
		String action = request.getContextPath()
				+ "/sell/sell.do?command=findByMedId";
		String hql = "from SellDetail s";
		Object[] where = null;
		if (id != null && !id.isEmpty()) {
			hql += " where s.med.id = ? order by s.sellTime desc";
			action += "&id=" + id;
			where = new Object[] { Integer.getInteger(id) };
		}
		//分布查询
		Map map = this.getPage(hql, recPerPage, currPage, action, where);
		//将结果集放到request中
		request.setAttribute("list", map.get("list"));
		//将结果集放到分页条中
		request.setAttribute("pagingBar", map.get("bar"));
		return mapping.findForward("findAllSuccess");
	}
}
