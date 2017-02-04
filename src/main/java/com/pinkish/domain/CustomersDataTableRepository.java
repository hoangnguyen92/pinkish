package com.pinkish.domain;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersDataTableRepository extends DataTablesRepository<Customer, Long> {
}