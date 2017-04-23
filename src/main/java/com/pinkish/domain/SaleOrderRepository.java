package com.pinkish.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pinkish.bean.TotalBalanceReportBean;

@Repository
public interface SaleOrderRepository extends CrudRepository<SaleOrder, Long> {
	SaleOrder findById(int id);
	@Query("select new com.pinkish.bean.TotalBalanceReportBean(sum(so.sum)) from SaleOrder so group by so.type,so.status order by so.type,so.status")
	List<TotalBalanceReportBean> generateTotalReport();
}