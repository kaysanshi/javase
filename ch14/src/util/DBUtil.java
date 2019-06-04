package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtil {
	private String driver;
	private String url;
	private String username;
	private String password;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	// 每页显示的记录数
	private int pageSize = 3;
	
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//构造方法，定义驱动程序连接用户名和密码信息
    public DBUtil(){
	  driver="com.mysql.jdbc.Driver";
	  url="jdbc:mysql://localhost:3306/ch14";
	  username="root";
	  password="root";
    }
	// 获取连接对象
	private Connection getConnection() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	// 获取语句对象
	private PreparedStatement getPrepareStatement(String sql) {
		try {
			pstmt = getConnection().prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}
	// 给pstmt的SQL语句设置参数（要求参数以数组形式给出）
	private void setParams(String sql, String[] params) {
		pstmt = this.getPrepareStatement(sql);
		if(params != null){
			for (int i = 0; i < params.length; i++){
				try {
					pstmt.setString(i + 1, params[i]);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}		
		}
	}
	// 执行数据库查询操作时，将返回的结果封装到List对象中
	public List getList(String sql, String[] params){
		List list = new ArrayList();
		try {
			this.setParams(sql, params);
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rs.next()) {
			    Map m = new HashMap();
			    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				   String colName = rsmd.getColumnName(i);
				   m.put(colName, rs.getString(colName));
			    }
			    list.add(m);
		    }
		 } catch (SQLException e) {
			e.printStackTrace();
		 }finally{
			close();
		}
		return list;
	}
	// 执行数据库查询操作时，将返回的结果封装到List对象中
	public Map getMap(String sql, String[] params){
		List list=getList(sql, params);
		if(list.isEmpty())
			return null;
		else
		    return (Map)list.get(0);
		
	}
	// 更新数据库时调用的update方法
	public int update(String sql, String[] params) {
		int recNo = 0;// 表示受影响的记录行数
		try {
			setParams(sql, params);// 根据sql语句和params，设置pstmt对象
			recNo = pstmt.executeUpdate();// 执行更新操作
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return recNo;
	}
	// 关闭对象
	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
		}
	}
	
	// 执行数据库查询操作时，返回结果的记录总数。
	private int getTotalRows(String sql, String[] params) {
		int totalRows = 0;
		sql = sql.toLowerCase();
		String countSql = "";
		if(sql.indexOf("group")>=0){
			countSql = "select count(*) from ("+sql+") as tempNum";
		}else{
			countSql = "select count(*) as tempNum "+ sql.substring(sql.indexOf("from"));
		}
		// count中存放总记录数
		String count = (String)getMap(countSql,params).get("tempNum");
		totalRows = Integer.parseInt(count);	
		return totalRows;
	}

	// 分页显示查询结果时，将当前页中的所有信息封装到PageBean中
	public PageBean getPageBean(String sql, String[] params, int curPage){
		String newSql = sql + " limit " + (curPage-1)*pageSize+","+pageSize;
		List data=this.getList(newSql, params);
		PageBean pb=new PageBean();
		pb.setCurPage(curPage);
		pb.setPageSize(pageSize);
		pb.setTotalRows(getTotalRows(sql, params));
		pb.setData(data);
		return pb;
	}
}