package com.pinkish.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.pinkish.domain.Customer;
import com.pinkish.domain.CustomerRepository;
import com.pinkish.domain.CustomersDataTableRepository;

@RestController()
@RequestMapping("/customers")
public class CustomerRestController {
	private static final Logger logger = LoggerFactory.getLogger(CustomerRestController.class);
	@Autowired
    private CustomersDataTableRepository customersDataTableRepository;
	@Autowired
    private CustomerRepository customersRepository;
	
    @JsonView(DataTablesOutput.View.class)
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public DataTablesOutput<Customer> getVendors(@Valid DataTablesInput input) {
        return customersDataTableRepository.findAll(input);
    }
    
    @RequestMapping(value= "/add", method = RequestMethod.POST)
	public Customer addPerson(Customer customer){
    	return customersDataTableRepository.save(customer);
	}
    
    
    @RequestMapping(value="/all", method = RequestMethod.GET)
    public List<Customer> getCustomer() {
        return (List<Customer>) customersRepository.findAll();
    }
    
    @RequestMapping(value="/{customerId}", method = RequestMethod.GET)
    public Customer getCustomers(@PathVariable Integer customerId) {
    	return (Customer) customersRepository.findById(customerId);
    }
}
