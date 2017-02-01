package com.pinkish.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesPaymentRepository extends CrudRepository<EmployeePayment, Long> {
	EmployeePayment findById(Integer id);
}