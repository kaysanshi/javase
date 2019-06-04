package util;

import java.util.List;
import java.util.Map;

import util.DButils;

public class TreeUtil {

	private DButils db;
	public TreeUtil(){
		db = new DButils();
		db.setUrl("jdbc:mysql://localhost:3306/db");
	}
	public String getTreeNodes() {
		StringBuffer buf = new StringBuffer();       //�������ɵ�JavaScript����
		buf.append("<script type='text/javascript'>");  //����JavaScript���
		buf.append("d = new dTree('d');");			 //����һ��dtree
		String sql = "select * from dtree";
		List l = db.getList(sql, null);
		for(Object o:l){
			Map m = (Map)o;
			buf.append("d.add(");
			buf.append(m.get("id") + ",");
			buf.append(m.get("pid") + ",'");
			buf.append(m.get("name") + "','");
			buf.append(m.get("url")+ "','");
			buf.append(m.get("title")+ "','");
			buf.append(m.get("target")+ "','");
			buf.append("img/"+m.get("icon")+ "','");
			buf.append("img/"+m.get("iconopen"));
			buf.append("');");
		}
		buf.append("document.write(d);");
		buf.append("</script>");
		return buf.toString();
	}
}
