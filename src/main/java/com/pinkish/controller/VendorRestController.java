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
import com.pinkish.domain.Vendor;
import com.pinkish.domain.VendorsDataTableRepository;

@RestController(value="/vendors")
public class VendorRestController {
	private static final Logger logger = LoggerFactory.getLogger(VendorRestController.class);
	@Autowired
    private VendorsDataTableRepository vendorsDataTableRepository;
	
    @JsonView(DataTablesOutput.View.class)
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public DataTablesOutput<Vendor> getVendors(@Valid DataTablesInput input) {
        return vendorsDataTableRepository.findAll(input);
    }
    
    @RequestMapping(value= "/add", method = RequestMethod.POST)
	public Vendor addPerson(Vendor vendor){
    	logger.info("==========================> "+vendor);
		return new Vendor();
	}
	
}
