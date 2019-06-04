package com.itheima.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.itheima.util.JDBCUtils;
/*
 	create table psbatch(
 		id int primary key auto_increment,
 		name varchar(30)
 	);
 */
/*
	prparedStatement 方式实现的批处理:
		优点:有预编译机制,效率比较高.执行多条结构相同,参数不同的sql时,不需要重复写sql的主干
		缺点:只能执行主干相同参数不同的sql,没有办法在一个批中加入结构不同的sql
 */
//批处理sql语句；
public class PSBatch {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement("insert into psbatch values(null,?)");
			
			for(int i=1;i<=100000;i++){
				ps.setString(1, "name"+i);
				ps.addBatch();
				
				if(i%1000==0){
					ps.executeBatch();
					ps.clearBatch();
				}
			}
			ps.executeBatch();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(null, ps, conn);
		}
	}
}
