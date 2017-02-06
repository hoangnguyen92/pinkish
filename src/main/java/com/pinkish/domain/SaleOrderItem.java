package com.pinkish.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "sale_orders_items", schema = "dbo", catalog = "pinkish")
public class SaleOrderItem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	@JsonView(DataTablesOutput.View.class)
	protected int id;
	
	@Column(name = "quantity", nullable = false)
	@JsonView(DataTablesOutput.View.class)
	private int quantity;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
 	@JoinColumn(name = "item_id", referencedColumnName = "id", nullable = true)
 	private Item item;
	
	@Column(name = "price", nullable = true)
	@JsonView(DataTablesOutput.View.class)
	private BigDecimal price;
	
    @Column(name = "sum", nullable = true)
    @JsonView(DataTablesOutput.View.class)
    private BigDecimal sum;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="sales_orders_id")
    private SaleOrder saleOrder;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
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

	public SaleOrder getSaleOrder() {
		return saleOrder;
	}

	public void setSaleOrder(SaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}
    
}
