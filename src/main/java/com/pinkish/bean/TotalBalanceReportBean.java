package com.pinkish.bean;

import java.math.BigDecimal;

public class TotalBalanceReportBean {
	private BigDecimal sum;

	public BigDecimal getSum() {
		return sum;
	}

	public void setSum(BigDecimal sum) {
		this.sum = sum;
	}

	public TotalBalanceReportBean(BigDecimal sum) {
		super();
		this.sum = sum;
	}
	
}
