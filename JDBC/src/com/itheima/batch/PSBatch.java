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
	prparedStatement ��ʽʵ�ֵ�������:
		�ŵ�:��Ԥ�������,Ч�ʱȽϸ�.ִ�ж����ṹ��ͬ,������ͬ��sqlʱ,����Ҫ�ظ�дsql������
		ȱ��:ֻ��ִ��������ͬ������ͬ��sql,û�а취��һ�����м���ṹ��ͬ��sql
 */
//������sql��䣻
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
