package com.pinkish.controller;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.FormParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.pinkish.domain.Employee;
import com.pinkish.domain.EmployeePayment;
import com.pinkish.domain.EmployeesDataTableRepository;
import com.pinkish.domain.EmployeesPaymentRepository;
import com.pinkish.domain.EmployeesRepository;

@RestController
public class EmployeeRestController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeRestController.class);
	@Autowired
    private EmployeesDataTableRepository employeesDataTableRepository;
	
	@Autowired
    private EmployeesPaymentRepository employeesPaymentRepository;
	
	@Autowired
    private EmployeesRepository employeesRepository;

	@JsonView(DataTablesOutput.View.class)
    @RequestMapping(value = "/data/users", method = RequestMethod.GET)
    public DataTablesOutput<Employee> getUsers(@Valid DataTablesInput input) {
        return employeesDataTableRepository.findAll(input);
    }
	
	@JsonView(DataTablesOutput.View.class)
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public List<Employee> getEmployees() {
        return (List<Employee>) employeesRepository.findAll();
    }
	
    @RequestMapping(value = "/data/employee-payment", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<EmployeePayment> getEmployeePayment() {
        return (List<EmployeePayment>) employeesPaymentRepository.findAll();
    }
    
    @RequestMapping(value= "/employee-payment/add", method = RequestMethod.POST)
	public EmployeePayment addPerson(@FormParam("employeeId") int employeeId,@FormParam("sum") double sum){
    	logger.info(employeeId +"===========================" + sum);
    	
    	Employee emp = employeesRepository.findById(employeeId);
    	EmployeePayment ep = new EmployeePayment();
    	ep.setEmployee(emp);
    	ep.setPaymentDate(new Timestamp(System.currentTimeMillis()));
    	ep.setSum(new BigDecimal(sum));
		return employeesPaymentRepository.save(ep);
	}
	
}
