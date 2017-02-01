package com.pinkish.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends CrudRepository<Employee, Long> {
    public List<Employee> findByFirstname(String firstname);
    public Employee findById(int id);
}