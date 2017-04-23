package com.pinkish.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "customers", schema = "dbo", catalog = "pinkish")
public class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	@JsonView(DataTablesOutput.View.class)
	protected int id;
	
	@Column(name = "name", nullable = false)
	@JsonView(DataTablesOutput.View.class)
	private String name;
	
	@Column(name = "address", nullable = false)
	@JsonView(DataTablesOutput.View.class)
	private String address;
	
	@Column(name = "telephone", nullable = true)
	@JsonView(DataTablesOutput.View.class)
    private String telephone;
	
    @Column(name = "mol", nullable = true)
    @JsonView(DataTablesOutput.View.class)
    private String mol;
    
    @Column(name = "bulstat", nullable = true)
	@JsonView(DataTablesOutput.View.class)
    private String bulstat;
    
	public String getBulstat() {
		return bulstat;
	}

	public void setBulstat(String bulstat) {
		this.bulstat = bulstat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMol() {
		return mol;
	}

	public void setMol(String mol) {
		this.mol = mol;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
