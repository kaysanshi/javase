package com.xiaoxiao.dao;

import java.util.List;
import java.util.Map;

import com.xiaoxiao.domain.Address;
import com.xiaoxiao.utils.JDBCUtils;

public class AddressDao {
	//删除一条记录
	public void delete(int id){
		String sql = "delete from address where addressid=?";
		JDBCUtils.update(sql, id);
	}
	
	//增加一条记录
	public void add(Address address){
		String sql = "insert into address values(null,?,?,?,?,?)";
		Object params[]={
				address.getAddressname(),address.getPostcode(),
				address.getReceiver(),address.getPhone(),address.getVipid()
		};
		int id =((Number)JDBCUtils.insert(sql, params)).intValue();
		address.setAddressid(id);
	}
	
	public List<Map<String,Object>> findAll(int vipid){
		String sql = "select * from address where vipid =?";
		return JDBCUtils.select(sql, vipid);
	}

	public Address findById(int addressid) {
		String sql = "select * from address where addressid =?";
		Address address = JDBCUtils.selectToBean(Address.class, sql, addressid);
//		Map<String,Object> item =JDBCUtils.select(sql, addressid).get(0);
//		//将item转为Address对象
//		Address address = new Address();
//		if(item.size()>0){
//			address.setAddressid(addressid);
//			address.setAddressname((String)item.get("addressname"));
//			address.setPhone((String)item.get("phone"));
//			address.setPostcode((String)item.get("postcode"));
//			address.setReceiver((String)item.get("receiver"));
//			address.setVipid((Integer)(item.get("vipid")));
//		}
		return address;
		
	}
}
