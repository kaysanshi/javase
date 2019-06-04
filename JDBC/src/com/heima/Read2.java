package com.heima;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//PreparedStatement和 Statement 对比;
//预处理的方式就是解决sql注入问题;一般效率会高;
//带参数的,复杂的用这个;
public class Read2 {
	
	static void read(String name){
		//使用的库类型为Java.sql包中的
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
	try {
			//创建连接
		conn=jdbcUtils.getConnection();
		long start=System.currentTimeMillis();
			//创建语句
		//在這要使用列的名來拿取簡單方便
		String sql="select stuId,stuName,stuSex,stuAge,stuDept from stu where stuName = ?";	
		//预处理的方式;
		ps=conn.prepareStatement(sql);
		ps.setString(1, name);//设置某一个值;
		//执行语句
		//
		rs=ps.executeQuery();
		while(rs.next()){
			System.out.println(rs.getObject("stuId")+"\t"+
		rs.getObject("stuName")+"\t"+rs.getObject("stuSex")+"\t"
		+rs.getObject("stuAge")+"\t"+rs.getObject("stuDept"));
		}
		long endtime=System.currentTimeMillis();
		System.out.println(endtime-start);
	} catch (SQLException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		jdbcUtils.free(rs, ps, conn);	
		}
	}
	public static void main(String[] args) {
//		read("流");
//		?????//查询所有的时候:1为真,0为假;
		read("'or 1 or'");
	}
}
