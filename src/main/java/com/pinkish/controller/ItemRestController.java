package com.pinkish.controller;

import java.util.List;

import javax.ws.rs.PathParam;

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
import com.pinkish.domain.VendorRepository;

@RestController()
@RequestMapping("/items")
public class ItemRestController {
	private static final Logger logger = LoggerFactory.getLogger(ItemRestController.class);
	
	@Autowired
    private ItemRepository itemRepository;
	@Autowired
    private VendorRepository vendorRepository;
	
	@Autowired
    private CategoryRepository categoryRepository;
	
	@RequestMapping(value = "/data", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Item> getItems() {
        return (List<Item>) itemRepository.findAll();
    }
	
	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Item> searchItem(@PathParam("term") String term) {
		if(term.equalsIgnoreCase("all")){
			return (List<Item>) itemRepository.findAll();
		}

		return itemRepository.findByNameContaining(term);
    }
    
    @RequestMapping(value= "/add", method = RequestMethod.POST)
	public Item addPerson(ItemBean item){
    	Item i = new Item();
    	i.setName(item.getName());
    	i.setQuantity(item.getQuantity());
    	i.setCost(item.getCost());
    	i.setPrice(item.getPrice());
    	i.setVendor(vendorRepository.findById(item.getVendorId()));
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
