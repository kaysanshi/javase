package com.zcib.utils;

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
/**
 * 操作数据库
 * @author 555
 *@date 2018年5月8日
 */
public class DBUtils {
	private String driver;
	private String username;
	private String url;
	private String password;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	// 每页显示的记录数
		private int pageSize = 5;
		
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public DBUtils() {
		// TODO Auto-generated constructor stub
		driver="com.mysql.jdbc.Driver";
		url="jdbc:mysql://localhost:3306/stexchange";
		username="root";
		password="root";
	}
	//获取连接对象
	private Connection getConnection(){
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//得到连接
			con=DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	//获取语句对象：
	private PreparedStatement getPrepareStatement(String sql){
		try {
			pstmt=getConnection().prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pstmt;
	}
	//给sql语句设置参数；
	private void setParams(String sql, String[]params) {
		pstmt=this.getPrepareStatement(sql);
		for(int i=0;i<params.length;i++){
			try {
				pstmt.setString(i+1, params[i]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//执行数据查询然后将换回的结果封装到List对象中；
	public List<Map<String, Object>> getList(String sql, String[]params){
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
	
		try {
			this.setParams(sql, params);
			ResultSet rs=pstmt.executeQuery();
			//获取表结构
			ResultSetMetaData rsmd=rs.getMetaData();
			//逐条读出记录
			while(rs.next()){
				//创建一个Map对象
				Map<String,Object>  map = new HashMap<String,Object>();
				for(int i=1;i<=rsmd.getColumnCount();i++){
					//表的字段名（rsmd.getColumnName(i)）为key，对应的值为value
					map.put(rsmd.getColumnName(i).toLowerCase(),rs.getObject(i));
				}
				list.add(map);//将这一条记录添加到list中
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
		
		for (Map<String, Object> map : list) {
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				System.out.println(entry.getKey() + ":" + entry.getValue());
			}
		}
		return list;
		
	}
	//查询的操作：
	public Map getMap(String sql, String[]params){
		List list=getList(sql, params);
		if(list.isEmpty()){
			return null;
		}else{
			return (Map)list.get(0);
		}
		
	}
	//更新数据库：
	public int update(String sql, String[]params){
		int recoder=0;//记录行数
		
		try {
			setParams(sql, params);
			recoder=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
		return recoder;
	}
	//关闭的方式
	private void close() {
		// TODO Auto-generated method stub
		
			try {
				if(rs!=null){
					rs.close();
				}if(pstmt!=null){
					pstmt.close();
				}if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	// 执行数据库查询操作时，返回结果的记录总数。
		public int getTotalRows(String sql, String[] params) {
			int totalRows = 0;
			sql = sql.toLowerCase();
			String countSql = "";
			if(sql.indexOf("group")>=0){
				//总记录数
				countSql = "select count(*) from ("+sql+") as tempNum";
				System.out.println("new:"+countSql);
			}else{
				//当前记录数
				countSql = "select count(*) as tempNum "+ sql.substring(sql.indexOf("from"));
				System.out.println("new1:"+countSql);
			}
				System.out.println(params);
			// count中存放总记录数
			String count = String.valueOf(getMap(countSql,params).get("tempnum"));
				
			System.out.println(count);
			totalRows = Integer.parseInt(count);	
			return totalRows;
		}

		// 分页显示查询结果时，将当前页中的所有信息封装到PageBean中
		public PageBean getPageBean(String sql, String[] params, int curPage){
			System.out.println("参数为：："+params);
			//分页语句
			String newSql = sql + " limit " + (curPage-1)*pageSize+","+pageSize;
			List data=this.getList(newSql, params);
			System.out.println("分页："+data);
			PageBean pb=new PageBean();
			//设置当前页数
			pb.setCurPage(curPage);
			//设置当前页数显示的行
			pb.setPageSize(pageSize);
			//设置总行数
			pb.setTotalRows(getTotalRows(sql, params));
			//每页显示的数据
			pb.setData(data);
			return pb;
		}
}

	
