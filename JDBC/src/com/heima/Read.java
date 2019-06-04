package com.heima;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.omg.CORBA.Current;
//PreparedStatement和 Statement 对比;
//sql的注入问题;会是数据库频繁的编译sql语句;
public class Read {
	//讀取;
		static void read(String name){
			//使用的库类型为Java.sql包中的
			Connection conn=null;
			Statement st=null;
			ResultSet rs=null;
		try {
				//创建连接
			conn=jdbcUtils.getConnection();
			long start=System.currentTimeMillis();
				//创建语句
			st=conn.createStatement();
			//在這要使用列的名來拿取簡單方便
			String sql="select stuId,stuName,stuSex,stuAge,stuDept from stu where stuName = '"+name+"'";	
			//执行语句
			//
			rs=st.executeQuery(sql);
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
			jdbcUtils.free(rs, st, conn);	
			}
		}
		public static void main(String[] args) {
			read("流");
//			//查询所有的时候:1为真,0为假;
//			read("'or 1 or'");
		}
}
