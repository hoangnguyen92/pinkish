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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "items", schema = "dbo", catalog = "pinkish")
public class Item implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	@JsonView(DataTablesOutput.View.class)
	protected int id;
	
	@Column(name = "name", nullable = false)
	@JsonView(DataTablesOutput.View.class)
	private String name;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
 	@JoinColumn(name = "category_id", referencedColumnName = "id", nullable = true)
 	private Category category;
	
	@Column(name = "quantity", nullable = true)
	@JsonView(DataTablesOutput.View.class)
    private Integer quantity;
	
    @Column(name = "cost", nullable = true)
    @JsonView(DataTablesOutput.View.class)
    private BigDecimal cost;
    
    @Column(name = "price", nullable = true)
    @JsonView(DataTablesOutput.View.class)
    private BigDecimal price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
