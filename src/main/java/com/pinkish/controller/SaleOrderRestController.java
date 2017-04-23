package com.pinkish.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pinkish.bean.SaleOrderBean;
import com.pinkish.bean.SaleOrderItemBean;
import com.pinkish.bean.TotalBalanceReportBean;
import com.pinkish.domain.CustomerRepository;
import com.pinkish.domain.Item;
import com.pinkish.domain.ItemRepository;
import com.pinkish.domain.SaleOrder;
import com.pinkish.domain.SaleOrderItem;
import com.pinkish.domain.SaleOrderItemRepository;
import com.pinkish.domain.SaleOrderRepository;
import com.pinkish.domain.VendorRepository;

@RestController()
@RequestMapping("/sale-order")
public class SaleOrderRestController {
	private static final Logger logger = LoggerFactory.getLogger(SaleOrderRestController.class);
	
	@Autowired
    private SaleOrderRepository saleOrderRepository;
	@Autowired
    private SaleOrderItemRepository saleOrderItemRepository;
	@Autowired
    private CustomerRepository customersRepository;
	@Autowired
    private VendorRepository vendorsRepository;
	@Autowired
    private ItemRepository itemsRepository;
	
	@RequestMapping(value = "/data", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<SaleOrder> getEmployeePayment() {
        return (List<SaleOrder>) saleOrderRepository.findAll();
    }
	@RequestMapping(value = "/pay", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody SaleOrder pay(@RequestParam("salesId") int id) {
		SaleOrder so = saleOrderRepository.findById(id);
		so.setStatus(2);
		so = saleOrderRepository.save(so);
        return so;
    }
	
	@RequestMapping(value = "/total-balance", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<TotalBalanceReportBean> getTotalBalance() {
        return saleOrderRepository.generateTotalReport();
    }
	
    @RequestMapping(value= "/add", method = RequestMethod.POST)
	public SaleOrder addPerson(SaleOrderBean item){
    	
    	if(item.getType().equalsIgnoreCase("sell")){
    		SaleOrder saleOrder = new SaleOrder();
    		BigDecimal sum = new BigDecimal(0);
    		int quantity = 0;
    		
    		saleOrder.setType(item.getType());
    		saleOrder.setCustomer(customersRepository.findById(item.getCustomerId()));
    		saleOrderRepository.save(saleOrder);
    		List<SaleOrderItem> saleOrdersItems = new ArrayList<>();
    		for(SaleOrderItemBean ib : item.getItems()){
    			SaleOrderItem i = new SaleOrderItem();
    			i.setItem(itemsRepository.findById(ib.getId()));
    			i.setQuantity(ib.getQuantity());
    			i.setSum(ib.getSum());
    			i.setPrice(ib.getPrice());
    			i.setSaleOrder(saleOrder);
    			sum = sum.add(ib.getSum());
    			quantity += ib.getQuantity();
    			i = saleOrderItemRepository.save(i);
    			saleOrdersItems.add(i);
    		}
    		saleOrder.setSum(sum);
    		saleOrder.setQuantity(quantity);
    		saleOrder.setStatus(1);
    		saleOrder.setItems(saleOrdersItems);
    		
    		return saleOrderRepository.save(saleOrder);
    	}else{
    		SaleOrder saleOrder = new SaleOrder();
    		BigDecimal sum = new BigDecimal(0);
    		int quantity = 0;
    		
    		saleOrder.setType(item.getType());
    		saleOrder.setVendor(vendorsRepository.findById(item.getVendorId()));
    		saleOrderRepository.save(saleOrder);
    		List<SaleOrderItem> saleOrdersItems = new ArrayList<>();
    		for(SaleOrderItemBean ib : item.getItems()){
    			SaleOrderItem i = new SaleOrderItem();
    			Item it = itemsRepository.findById(ib.getId());
    			if(ib.getIsNew()){
    				it.setQuantity(it.getQuantity()+ib.getQuantity());
    			}else{
    				it.setQuantity(ib.getQuantity());
    			}
    			it = itemsRepository.save(it);
    			i.setItem(it);
    			i.setQuantity(ib.getQuantity());
    			i.setSum(ib.getSum());
    			i.setPrice(ib.getPrice());
    			i.setSaleOrder(saleOrder);
    			sum = sum.add(ib.getSum());
    			quantity += ib.getQuantity();
    			i = saleOrderItemRepository.save(i);
    			saleOrdersItems.add(i);
    		}
    		saleOrder.setSum(sum);
    		saleOrder.setQuantity(quantity);
    		saleOrder.setStatus(1);
    		saleOrder.setItems(saleOrdersItems);
    		
    		return saleOrderRepository.save(saleOrder);
    	}
	}
}
