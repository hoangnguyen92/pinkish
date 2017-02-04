package com.pinkish.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.pinkish.domain.Customer;
import com.pinkish.domain.CustomersDataTableRepository;
import com.pinkish.domain.Vendor;
import com.pinkish.domain.VendorsDataTableRepository;

@RestController()
@RequestMapping("/customers")
public class CustomerRestController {
	private static final Logger logger = LoggerFactory.getLogger(CustomerRestController.class);
	@Autowired
    private CustomersDataTableRepository customersDataTableRepository;
	
	
    @JsonView(DataTablesOutput.View.class)
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public DataTablesOutput<Customer> getVendors(@Valid DataTablesInput input) {
        return customersDataTableRepository.findAll(input);
    }
    
    @RequestMapping(value= "/add", method = RequestMethod.POST)
	public Customer addPerson(Customer customer){
    	return customersDataTableRepository.save(customer);
	}
	
}
