package com.pinkish.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.pinkish.domain.Employee;
import com.pinkish.domain.EmployeesDataTableRepository;

@RestController
public class EmployeeRestController {
	@Autowired
    private EmployeesDataTableRepository employeesDataTableRepository;

	@JsonView(DataTablesOutput.View.class)
    @RequestMapping(value = "/data/users", method = RequestMethod.GET)
    public DataTablesOutput<Employee> getUsers(@Valid DataTablesInput input) {
        return employeesDataTableRepository.findAll(input);
    }
}
