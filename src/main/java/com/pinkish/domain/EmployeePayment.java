package com.pinkish.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "employees_payments", schema = "dbo", catalog = "pinkish")
public class EmployeePayment implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	@JsonView(DataTablesOutput.View.class)
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
	@JsonView(DataTablesOutput.View.class)
	private Employee employee;
	
	@Column(name = "payment_date", nullable = true)
	@JsonView(DataTablesOutput.View.class)
	private Timestamp paymentDate;
	
	@Column(name = "sum", nullable = true)
    @JsonView(DataTablesOutput.View.class)
    private BigDecimal sum;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Timestamp getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}

	public BigDecimal getSum() {
		return sum;
	}

	public void setSum(BigDecimal sum) {
		this.sum = sum;
	}

}
