package com.pinkish.bean;

import java.io.Serializable;
import java.util.List;

public class SaleOrderBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private String type;
	private Integer customerId;
	private Integer vendorId;
	private List<SaleOrderItemBean> items;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getVendorId() {
		return vendorId;
	}
	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}
	public List<SaleOrderItemBean> getItems() {
		return items;
	}
	public void setItems(List<SaleOrderItemBean> items) {
		this.items = items;
	}
	
}
