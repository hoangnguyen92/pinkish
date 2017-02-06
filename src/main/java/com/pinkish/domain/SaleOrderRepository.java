package com.pinkish.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleOrderRepository extends CrudRepository<SaleOrder, Long> {
	SaleOrder findById(int id);
}