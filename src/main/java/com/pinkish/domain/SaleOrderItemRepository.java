package com.pinkish.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleOrderItemRepository extends CrudRepository<SaleOrderItem, Long> {
	SaleOrderItem findById(int id);
}