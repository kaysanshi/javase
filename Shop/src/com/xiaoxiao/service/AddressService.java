package com.xiaoxiao.service;

import java.util.List;
import java.util.Map;

import com.xiaoxiao.dao.AddressDao;
import com.xiaoxiao.domain.Address;

public class AddressService {
	private AddressDao addressDao = new AddressDao();
	//增加地址
	public void add(Address address){
		addressDao.add(address);
	}
	
	//获取用户vipid的地址列表
	public List<Map<String,Object>> findById(int vipid){
		return addressDao.findAll(vipid);
	}
	
	public void deleteById(int id){
		addressDao.delete(id);
	}

	public Address find(int addressid) {
		//根据addressid来获取该条地址
		return addressDao.findById(addressid);
		
	}
}
