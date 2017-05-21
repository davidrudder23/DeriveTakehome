package org.dave.derive.salesorder;

import org.dave.derive.item.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/salesorder")
public class SalesOrderController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	SalesOrderService salesOrderService;

	@Autowired
	ItemService itemService;

    
    @RequestMapping(method={RequestMethod.GET}, value="/{id}")
    @ResponseBody
    public ResponseEntity<SalesOrder> getById(@PathVariable("id") Long id) {
    	SalesOrder po = salesOrderService.getById(id);
    	
        return new ResponseEntity<SalesOrder>(po, HttpStatus.OK);
    }

    @RequestMapping(method={RequestMethod.POST}, value="")
    @ResponseBody
    public ResponseEntity<Long> insert(@RequestBody SalesOrder salesOrder) {    
    	LOG.error("SalesOrder lines={}", salesOrder.getSalesOrderLines());
    	//Item item = itemService.getById(itemId);
    	//purchaseOrder.setItem(Key.create(Item.class, item.getId()));
    	Long id = salesOrderService.insert(salesOrder);
    	
        return new ResponseEntity<Long>(id, HttpStatus.OK);
    }
    
    @RequestMapping(method={RequestMethod.PUT}, value="/{id}")
    @ResponseBody
    public ResponseEntity<Long> update(@PathVariable("id") Long id, @RequestBody SalesOrder salesOrder) {
    	
    	// Trust the ID in the path over the ID in the json
    	// We'll need to add authorization, and it's easiest to filter on the URL
    	salesOrder.setId(id);
    	Long newId = salesOrderService.update(salesOrder);
    	
        return new ResponseEntity<Long>(newId, HttpStatus.OK);
    }
	
}
