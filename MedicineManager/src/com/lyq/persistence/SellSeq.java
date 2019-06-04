package com.lyq.persistence;
/**
 * 销售排行实体类
 * 用于封装销售统计信息
 * @author Li Yong Qiang
 */
public class SellSeq {
	private String name;		//名称	
	private Double totalPrice;	//总价
	private Long totalCount;	//总数量
	private Integer medId;		//药品id
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getMedId() {
		return medId;
	}
	public void setMedId(Integer medId) {
		this.medId = medId;
	}
}
