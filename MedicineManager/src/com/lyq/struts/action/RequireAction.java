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
/**
 * 药品需求Action类
 * @author Li Yong Qiang
 */
public class RequireAction extends BaseAction {
	//编辑需求药品
	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		MedicineForm df = (MedicineForm)form;
		if(df.getId() > 0){
			MedicineDao dao = new MedicineDao();
			Medicine med = dao.loadMedicine(df.getId());
			BeanUtils.copyProperties(df, med);
			df.setCategoryId(med.getCategory().getId());
		}
		//获取药品类别信息
		CategoryDao dao = new CategoryDao();
		List cs = dao.findAllCategory();
		request.setAttribute("cs", cs);
		return mapping.findForward("medSave");
	}
	//添加需求药品
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Medicine med = null;
		MedicineForm df = (MedicineForm)form;
		if(df.getReqCount() == 0){
			df.setReqCount(1);
		}
		MedicineDao medDao = new MedicineDao();
		//需求已存在，更新数量
		if(df.getId() > 0){
			med = medDao.loadMedicine(df.getId());
			//更新需求量
			int reqCount = med.getReqCount();
			med.setReqCount(df.getReqCount());
		}else{//需求不存在，添加需求
			med = new Medicine();
			BeanUtils.copyProperties(med, df);
			CategoryDao cd = new CategoryDao();
			Category category = cd.loadCategory(df.getCategoryId());
			med.setCategory(category);
		}
		//上传
		FormFile photo = df.getPhoto();
		if(photo != null && photo.getFileSize() > 0){
			String realPath = this.getServlet().getServletContext().getRealPath("/upload");
			System.out.println(realPath);
			//将文件上传至服务器中指定的文件下
			try {
				String fname = photo.getFileName(); 					//获取上传文件名称
				if(fname.indexOf(".") != -1){
					String endWith = fname.substring(fname.lastIndexOf("."), fname.length());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
					fname = sdf.format(new Date()) + endWith;
				}
				//向服务器中写入文件 
				OutputStream out = new FileOutputStream(realPath + "/" + fname); 	//创建写入服务器地址的输出流对象
				out.write(photo.getFileData());
				out.flush();
				out.close();
				med.setPhotoPath(fname);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		medDao.saveOrUpdate(med);
		return mapping.findForward("addSuccess");
	}
	
	//更新需求信息
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		MedicineForm df = (MedicineForm)form;
		Medicine med = null;
		if(df.getId() > 0){
			MedicineDao dao = new MedicineDao();
			med = dao.loadMedicine(df.getId());
			BeanUtils.copyProperties(df, med);
		}
		return mapping.findForward("medUpdate");
	}
	//根据medNo查询
	public ActionForward findMedicineByMedNo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		MedicineForm df = (MedicineForm)form;
		Medicine med = null;
		//查询需求中是否存在
		if(df != null && df.getMedNo() != null){
			MedicineDao dao = new MedicineDao();
			med = dao.findMedicineByMedNo(df.getMedNo());
		}
		if(med != null){
			//查到信息
			//request.setAttribute("med", "med");
			BeanUtils.copyProperties(df, med);
			return mapping.findForward("medUpdate");
		}else{
			CategoryDao cd = new CategoryDao();
			List list = cd.findByHQL("from Category");
			request.setAttribute("cs", list);
			return mapping.findForward("medSave");
		}
	}

	//分页查询
	public ActionForward paging(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//获取当前页码
		String currPage = request.getParameter("currPage");
		String action = request.getContextPath()+"/require/require.do?command=paging";
		String hql = "from Medicine d where d.reqCount > 0 or d.medCount <= 0";
		//分页查询
		Map map = this.getPage(hql, recPerPage, currPage, action, null);
		//将结果集放到request中
		request.setAttribute("list", map.get("list"));
		//将结果集放到分页条中
		request.setAttribute("pagingBar", map.get("bar"));
		return mapping.findForward("findAllSuccess");
	}
	//更新药品进货完成
	public ActionForward meded(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		MedicineForm df = (MedicineForm)form;	// 获取MedicineForm
		Medicine med = null;
		if(df.getId() > 0){
			MedicineDao dao = new MedicineDao();	// 实例化MedicineDao
			med = dao.loadMedicine(df.getId());		// 加载药品信息
			if(med != null){
				// 更新药品数量
				med.setMedCount(med.getMedCount() + med.getReqCount());
				med.setReqCount(0);		// 更新药品需求
				dao.saveOrUpdate(med);	// 更新药品对象
			}
		}
		return mapping.findForward("addSuccess");
	}
	//模糊查询,分页显示
	public ActionForward blurQuery(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//获取关键词
		String keyWord = request.getParameter("keyWord");
		//获取当前页码
		String currPage = request.getParameter("currPage");
		String action = request.getContextPath()+"/require/require.do?command=blurQuery";
		String hql = "from Medicine d where d.reqCount > 0";
		Object[] where = null;
		//转码
		if(currPage != null && !currPage.isEmpty()){
			keyWord = new String(keyWord.getBytes("iso-8859-1"),"gbk");
		}
		if (keyWord != null && !keyWord.isEmpty()) {
			keyWord = "%" + keyWord + "%";
			hql += " where d.name like ? or d.medNo like ? or d.factoryAdd like ? or d.description like ?";
			action += "&keyWord=" + keyWord;
			where = new Object[]{keyWord,keyWord,keyWord,keyWord};
		}
		//分页查询
		Map map = this.getPage(hql, recPerPage, currPage, action, where);
		//将结果集放到request中
		request.setAttribute("list", map.get("list"));
		//将结果集放到分页条中
		request.setAttribute("pagingBar", map.get("bar"));
		return mapping.findForward("findAllSuccess");
	}
	
	
}
