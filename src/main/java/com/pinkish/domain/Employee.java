package com.pinkish.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "employees", schema = "dbo", catalog = "pinkish")
public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	@JsonView(DataTablesOutput.View.class)
	protected int id;
	
	@Column(name = "firstname", nullable = false)
	@JsonView(DataTablesOutput.View.class)
	private String firstname;
	
	@Column(name = "lastname", nullable = false)
	@JsonView(DataTablesOutput.View.class)
	private String lastname;
	
	@Column(name = "email", nullable = true)
	@JsonView(DataTablesOutput.View.class)
    private String email;
	
    @Column(name = "phone", nullable = true)
    @JsonView(DataTablesOutput.View.class)
    private String phone;
    
    @Column(name = "weekly_rate", nullable = true)
    @JsonView(DataTablesOutput.View.class)
    private BigDecimal weeklyRate;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public BigDecimal getWeeklyRate() {
		return weeklyRate;
	}

	public void setWeeklyRate(BigDecimal weeklyRate) {
		this.weeklyRate = weeklyRate;
	}
	
}
