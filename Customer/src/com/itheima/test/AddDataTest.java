package com.itheima.test;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.itheima.utils.DaoUtils;

public class AddDataTest {
		public AddDataTest(){
			String sql="insert into customer values(null,?,?,?,?,?,?,?,?)";
			try {
				QueryRunner runner=new QueryRunner(DaoUtils.getSource());
				for(int i=0;i<=100;i++){
					runner.update(sql,"name"+i+"��","��","2012-1-11","12345678","123456@qq.com","����","�׽�ͻ�","����"+i);
				} 
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("������������");
			}
			
		}
}