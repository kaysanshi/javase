package cn.test.memo.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.test.memo.entity.Record;
import cn.test.memo.service.RecordService;
import cn.test.memo.util.ResultUtil;

/**
 * 备忘录相关的所有操作
 * 1.获取备忘录列表
 * 2.添加备忘录
 * 3.获取修改备忘录(修改备忘录 分两步 1.获取数据返回给页面edit.jsp 2.保存数据 save)
 * 4.删除备忘录
 * 5.查看备忘录
 * @author Qfeng
 *
 */
public class RecordAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private RecordService recordService;
	
	public RecordAction() {
		this.recordService = new RecordService();
	}
	
	/**
	 * 获取备忘录列表
	 * @return
	 */
	public String list() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String p = request.getParameter("p");
		int page = 0;
		if (p == null || p.isEmpty() || Integer.parseInt(p) < 0) 
			page = 0;
		else
			page = Integer.parseInt(p);
		int pageNum = 10;
		List<Record> list = recordService.query(pageNum, page);
		int sum = recordService.queryNum();
		request.setAttribute("list", list);
		request.setAttribute("sum", sum);
		request.setAttribute("page", page + 1);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("tp", sum % pageNum == 0 ? sum / pageNum : sum / pageNum + 1);
		return "list";
	}
	
	/**
	 * 添加备忘录
	 * @return
	 */
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, Object> map = new HashMap<>();
		String title = request.getParameter("title");
		String text = request.getParameter("content");
		String time = request.getParameter("date");
		if (title == null || title.isEmpty() || text == null || text.isEmpty() || time == null || time.isEmpty()) {
			map.put("status", 0);
			map.put("msg", "内容不全");
			ResultUtil.toJson(ServletActionContext.getResponse(), map);
			return NONE;
		}
		Record record = new Record();
		record.setTitle(title);
		record.setText(text);
		record.setTime(time);
		if (recordService.add(record)) {
			map.put("status", 1);
			map.put("msg", "添加成功");
		} else {
			map.put("status", 0);
			map.put("msg", "添加失败");
		}
		ResultUtil.toJson(ServletActionContext.getResponse(), map);
		return NONE;
	}
	
	/**
	 * 获取原来的数据返回给edit.jsp以供修改
	 * @return
	 */
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		if (id == null || id.isEmpty()) {
			return NONE;
		}
		Record record = recordService.query(Integer.parseInt(id));
		if (record == null) {
			return NONE;
		}
		request.setAttribute("record", record);
		return "edit";
	}
	
	/**
	 * 保存备忘录 保存修改后的信息
	 * @return
	 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, Object> map = new HashMap<>();
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String text = request.getParameter("content");
		String time = request.getParameter("date");
		if (id == null || id.isEmpty() || title == null || title.isEmpty() || text == null || text.isEmpty() || time == null || time.isEmpty()) {
			map.put("status", 0);
			map.put("msg", "内容不全");
			ResultUtil.toJson(ServletActionContext.getResponse(), map);
			return NONE;
		}
		Record record = recordService.query(Integer.parseInt(id));
		if (record == null) {
			map.put("status", 0);
			map.put("msg", "未找到相关记录");
			ResultUtil.toJson(ServletActionContext.getResponse(), map);
			return NONE;
		}
		record.setTitle(title);
		record.setText(text);
		record.setTime(time);
		if (recordService.update(record)) {
			map.put("status", 1);
			map.put("msg", "修改成功");
		} else {
			map.put("status", 0);
			map.put("msg", "修改失败");
		}
		ResultUtil.toJson(ServletActionContext.getResponse(), map);
		return NONE;
	}
	
	/**
	 * 查看备忘录
	 * @return
	 */
	public String info() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		if (id == null || id.isEmpty()) {
			return NONE;
		}
		Record record = recordService.query(Integer.parseInt(id));
		if (record == null) {
			return NONE;
		}
		request.setAttribute("record", record);
		return "info";
	}
	
	/**
	 * 删除备忘录
	 * @return
	 */
	public String del() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, Object> map = new HashMap<>();
		String id = request.getParameter("id");
		if (id == null || id.isEmpty()) {
			map.put("status", 0);
			map.put("msg", "内容不全");
			ResultUtil.toJson(ServletActionContext.getResponse(), map);
			return NONE;
		}
		Record record = recordService.query(Integer.parseInt(id));
		if (record == null) {
			map.put("status", 0);
			map.put("msg", "未找到相关记录");
			ResultUtil.toJson(ServletActionContext.getResponse(), map);
			return NONE;
		}
		if (recordService.delete(record)) {
			map.put("status", 1);
			map.put("msg", "删除成功");
		} else {
			map.put("status", 0);
			map.put("msg", "删除失败");
		}
		ResultUtil.toJson(ServletActionContext.getResponse(), map);
		return NONE;
	}
}















































