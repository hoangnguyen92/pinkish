package com.pinkish.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class SaleOrderItemBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer quantity;
	private BigDecimal price;
	private BigDecimal sum;
	private Boolean isNew;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getSum() {
		return sum;
	}
	public void setSum(BigDecimal sum) {
		this.sum = sum;
	}
	public Boolean getIsNew() {
		return isNew;
	}
	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}
}
