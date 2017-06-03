package com.pinkish.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pinkish.bean.TotalBalanceReportBean;

@Repository
public interface SaleOrderRepository extends CrudRepository<SaleOrder, Long> {
	SaleOrder findById(int id);
	@Query("select new com.pinkish.bean.TotalBalanceReportBean(sum(so.sum)) from SaleOrder so where so.type='sell' and so.status=2")
	TotalBalanceReportBean generateTotalPaidSales();
	
	@Query("select new com.pinkish.bean.TotalBalanceReportBean(sum(so.sum)) from SaleOrder so where so.type='sell' and so.status=1")
	TotalBalanceReportBean generateTotalUnpaidSales();
	
	@Query("select new com.pinkish.bean.TotalBalanceReportBean(sum(so.sum)) from SaleOrder so where so.type='buy' and so.status=2")
	TotalBalanceReportBean generateTotalPaidPurchase();
	
	@Query("select new com.pinkish.bean.TotalBalanceReportBean(sum(so.sum)) from SaleOrder so where so.type='buy' and so.status=1")
	TotalBalanceReportBean generateTotalUnpaidPurchase();
}