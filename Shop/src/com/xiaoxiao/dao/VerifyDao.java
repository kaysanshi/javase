package com.xiaoxiao.dao;

import java.sql.Timestamp;
import java.util.Date;

import com.xiaoxiao.domain.Verify;
import com.xiaoxiao.utils.JDBCUtils;

public class VerifyDao {

	public void addverify(int vipid,String code,Date dt){
		String sql = "insert into tverifycode values(null,?,?,?)";
		Object params[]={
				code,new Timestamp(dt.getTime()),vipid
		};
		JDBCUtils.insert(sql, params);
	}
	
	public Verify findByCode(String code){
		String sql = "select * from tverifycode where code=?";
		Verify vr = JDBCUtils.selectToBean(Verify.class, sql, code);
		return vr;
	}
}
