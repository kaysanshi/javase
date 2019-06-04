package com.lyq.struts.form;

import java.util.Date;
import org.apache.struts.action.ActionForm;
/**
 * 销售信息FromBean
 * @author Li Yong Qiang
 */
public class SellDetailForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private int id; 			// 编号
	private String sellName; 	// 名称
	private double sellPrice; 	// 单价
	private int sellCount; 		// 数量
	private String factoryAdd; 	// 厂家
	private double total;		// 总额
	private Date SellTime; 		// 日期
	private int medId; 			// 药品id
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getFactoryAdd() {
		return factoryAdd;
	}
	public void setFactoryAdd(String factoryAdd) {
		this.factoryAdd = factoryAdd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSellName() {
		return sellName;
	}
	public void setSellName(String sellName) {
		this.sellName = sellName;
	}
	public double getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}
	public int getSellCount() {
		return sellCount;
	}
	public void setSellCount(int sellCount) {
		this.sellCount = sellCount;
	}
	public Date getSellTime() {
		return SellTime;
	}
	public void setSellTime(Date sellTime) {
		SellTime = sellTime;
	}
	public int getMedId() {
		return medId;
	}
	public void setMedId(int medId) {
		this.medId = medId;
	}
}
