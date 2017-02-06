package com.pinkish.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "sale_orders", schema = "dbo", catalog = "pinkish")
public class SaleOrder implements Serializable{
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
 	@JoinColumn(name = "vendors_id", referencedColumnName = "id", nullable = true)
 	private Vendor vendor;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
 	@JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = true)
 	private Customer customer;
	
	@Column(name = "type", nullable = true)
	@JsonView(DataTablesOutput.View.class)
    private String type;
	
    @Column(name = "sum", nullable = true)
    @JsonView(DataTablesOutput.View.class)
    private BigDecimal sum;
    
    @Column(name = "status", nullable = true)
    @JsonView(DataTablesOutput.View.class)
    private int status;
    
    @Column(name = "discount", nullable = true)
    @JsonView(DataTablesOutput.View.class)
    private BigDecimal discount;
    
    @OneToMany(mappedBy="saleOrder")
    @JsonIgnore
    private List<SaleOrderItem> items;

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

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getSum() {
		return sum;
	}

	public void setSum(BigDecimal sum) {
		this.sum = sum;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public List<SaleOrderItem> getItems() {
		return items;
	}

	public void setItems(List<SaleOrderItem> items) {
		this.items = items;
	}
	
}
