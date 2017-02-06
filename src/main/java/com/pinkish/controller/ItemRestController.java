package com.pinkish.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pinkish.bean.ItemBean;
import com.pinkish.domain.Category;
import com.pinkish.domain.CategoryRepository;
import com.pinkish.domain.Item;
import com.pinkish.domain.ItemRepository;

@RestController()
@RequestMapping("/items")
public class ItemRestController {
	private static final Logger logger = LoggerFactory.getLogger(ItemRestController.class);
	
	@Autowired
    private ItemRepository itemRepository;
	
	@Autowired
    private CategoryRepository categoryRepository;
	
	@RequestMapping(value = "/data", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Item> getEmployeePayment() {
        return (List<Item>) itemRepository.findAll();
    }
    
    @RequestMapping(value= "/add", method = RequestMethod.POST)
	public Item addPerson(ItemBean item){
    	Item i = new Item();
    	i.setName(item.getName());
    	i.setQuantity(item.getQuantity());
    	i.setCost(item.getCost());
    	i.setPrice(item.getPrice());
    	Category cat = categoryRepository.findByName(item.getCategory());
    	if(cat == null){
    		Category c = new Category();
    		c.setName(item.getCategory());
    		cat = categoryRepository.save(c);
    	}
    	i.setCategory(cat);
		return itemRepository.save(i);
	}
}
