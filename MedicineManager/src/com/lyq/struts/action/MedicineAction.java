package com.lyq.struts.action;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.lyq.dao.CategoryDao;
import com.lyq.dao.MedicineDao;
import com.lyq.persistence.Category;
import com.lyq.persistence.Medicine;
import com.lyq.struts.form.MedicineForm;
import com.lyq.util.QueryUtil;
import com.lyq.util.StringUtil;

/**
 * 药品Action类
 * @author Li Yong Qiang
 */
public class MedicineAction extends BaseAction {

	// 添加药品
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Medicine med = null;
		// 获取MedicineForm
		MedicineForm df = (MedicineForm) form;
		MedicineDao dao = new MedicineDao();
		if (df.getMedCount() == 0) {
			df.setMedCount(1);
		}
		med = new Medicine();
		BeanUtils.copyProperties(med, df);
		CategoryDao cd = new CategoryDao();
		Category category = cd.loadCategory(df.getCategoryId());
		med.setCategory(category);
		// 上传图片
		FormFile photo = df.getPhoto();
		if (photo != null && photo.getFileSize() > 0) {
			String realPath = this.getServlet().getServletContext()
					.getRealPath("/upload");
			// 将文件上传至服务器中指定的文件下
			try {
				String fname = photo.getFileName(); // 获取上传文件名称
				if (fname.indexOf(".") != -1) {
					// 获取文件的扩展名
					String endWith = fname.substring(fname.lastIndexOf("."),fname.length());
					// 用当前的时间生成文件名称
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
					fname = sdf.format(new Date()) + endWith;
				}
				// 创建写入服务器地址的输出流对象
				OutputStream out = new FileOutputStream(realPath + "/" + fname); 
				out.write(photo.getFileData());	// 将文件写入到服务器
				out.flush();
				out.close();
				// 将文件名称保存到数据库
				med.setPhotoPath(fname);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		dao.saveOrUpdate(med);
		return mapping.findForward("addSuccess");
	}
	// 添加药品
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 获取MedicineForm
		MedicineForm df = (MedicineForm) form;
		MedicineDao dao = new MedicineDao();
		// 药品已存在，更新药品数量
		Medicine med = dao.loadMedicine(df.getId());
		int medCount = med.getMedCount();
		med.setMedCount(medCount + df.getMedCount());
		return mapping.findForward("addSuccess");
	}
	// 根据medNo查询药品
	public ActionForward findMedicineByMedNo(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 获取MedicineForm
		MedicineForm df = (MedicineForm) form;
		Medicine med = null;
		// 查询药品
		if (df != null && df.getMedNo() != null) {
			MedicineDao dao = new MedicineDao();
			med = dao.findMedicineByMedNo(df.getMedNo());
		}
		// 如果药品存在，更新数量，否则添加新药
		if (med != null) {
			BeanUtils.copyProperties(df, med);
			request.setAttribute("med", "med");
			return mapping.findForward("medUpdate");
		} else {
			CategoryDao cd = new CategoryDao();
			List list = cd.findByHQL("from Category");
			request.setAttribute("cs", list);
			return mapping.findForward("medSave");
		}
	}

	// 分页查询药品信息
	public ActionForward paging(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 获取页码
		String currPage = request.getParameter("currPage");
		// 构建action地址
		String action = request.getContextPath() + "/baseData/med.do?command=paging";
		// HQL查询语句
		String hql = "from Medicine";
		// 分页查询，返回Map对象
		Map map = this.getPage(hql, recPerPage, currPage, action, null);
		//将结果集放到request中
		request.setAttribute("list", map.get("list"));
		//将结果集放到分页条中
		request.setAttribute("pagingBar", map.get("bar"));
		return mapping.findForward("findAllSuccess");
	}

	// 查看药品详细信息
	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("id");
		Medicine med = null;
		// 根据id查询药品信息
		if (id != null && !"".equals(id)) {
			MedicineDao dao = new MedicineDao();
			med = dao.loadMedicineAndCategory(Integer.parseInt(id));
		}
		request.setAttribute("med", med);
		return mapping.findForward("view");
	}

	// 编辑药品信息
	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 获取MedicineForm
		MedicineForm df = (MedicineForm) form;
		Medicine med = null;
		// 根据id查询药品
		if (df.getId() > 0) {
			MedicineDao dao = new MedicineDao();
			med = dao.loadMedicineAndCategory(df.getId());
			BeanUtils.copyProperties(df, med);
			df.setCategoryId(med.getCategory().getId());
		}
		// 获取类别信息
		CategoryDao categoryDao = new CategoryDao();
		List cs = categoryDao.findByHQL("from Category");
		request.setAttribute("cs", cs);
		return mapping.findForward("medSave");
	}

	// 多条件查询，分页显示结果
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 获取MedicineForm
		MedicineForm df = (MedicineForm) form;
		String currPage = request.getParameter("currPage");
		// 构造查询Action
		String action = request.getContextPath() + "/baseData/med.do?command=query";
		//构造HQL语句及分页条件
		Map mapQuery = QueryUtil.queryMedicine(df, currPage, action);
		String hql = (String) mapQuery.get("hql");
		action = (String) mapQuery.get("action");
		Object[] where = (Object[]) mapQuery.get("where");
		// 分页查询
		Map map = this.getPage(hql, recPerPage, currPage, action, where);
		//将结果集放到request中
		request.setAttribute("list", map.get("list"));
		//将结果集放到分页条中
		request.setAttribute("pagingBar", map.get("bar"));
		return mapping.findForward("findAllSuccess");
	}

	// 模糊查询
	public ActionForward blurQuery(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 获取关键词
		String keyWord = request.getParameter("keyWord");
		// 获取当前页
		String currPage = request.getParameter("currPage");
		String hql = "from Medicine d ";
		Object[] where = null;
		String action = request.getContextPath() + "/baseData/med.do?command=blurQuery";
		// 转码
		if (currPage != null && !currPage.isEmpty()) {
			keyWord = StringUtil.encodeZh(keyWord);
		}
		if (keyWord != null && !keyWord.isEmpty()) {
			action += "&keyWord=" + StringUtil.encodeURL(keyWord);
			keyWord = "%" + keyWord + "%";
			hql += " where d.name like ? or d.medNo like ? or d.factoryAdd like ? or d.description like ?";
			where = new Object[] { keyWord, keyWord, keyWord, keyWord };
		}
		// 分页查询
		Map map = this.getPage(hql, recPerPage, currPage, action, where);
		//将结果集放到request中
		request.setAttribute("list", map.get("list"));
		//将结果集放到分页条中
		request.setAttribute("pagingBar", map.get("bar"));
		return mapping.findForward("findAllSuccess");
	}

	// 浏览可买的药品
	public ActionForward canSellMeds(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// HQL查询条件
		String hql = "from Medicine d where d.medCount > 0";
		// 获取当前页
		String currPage = request.getParameter("currPage");
		String action = request.getContextPath() + "/baseData/med.do?command=canSellMeds";
		// 分页查询
		Map map = this.getPage(hql, recPerPage, currPage, action, null);
		//将结果集放到request中
		request.setAttribute("list", map.get("list"));
		//将结果集放到分页条中
		request.setAttribute("pagingBar", map.get("bar"));
		return mapping.findForward("canSellMeds");
	}

	// 查询库存
	public ActionForward QueryMedCount(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 获取查询数量
		String count = request.getParameter("count");
		// 获取查询类型（>、<、=）
		String type = request.getParameter("type");
		// 获取当前页
		String currPage = request.getParameter("currPage");
		Object[] where = null;
		String hql = "from Medicine d";
		String action = request.getContextPath() + "/require/require.do?command=blurQuery";
		if (count != null && type != null) {
			// 构造条件
			if (type.equals("0")) {
				hql = "from Medicine d where d.medCount = ?";
			} else if (type.equals("1")) {
				hql = "from Medicine d where d.medCount > ?";
			} else if (type.equals("-1")) {
				hql = "from Medicine d where d.medCount < ?";
			}
			action = action + "&type=" + type + "&count=" + count;
			where = new Object[] { new Integer(count) };
		}
		// 分页查询
		Map map = this.getPage(hql, recPerPage, currPage, action, where);
		//将结果集放到request中
		request.setAttribute("list", map.get("list"));
		//将结果集放到分页条中
		request.setAttribute("pagingBar", map.get("bar"));
		return mapping.findForward("findAllSuccess");
	}
}
