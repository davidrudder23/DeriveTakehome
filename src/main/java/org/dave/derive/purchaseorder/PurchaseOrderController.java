package org.dave.derive.purchaseorder;

import org.dave.derive.item.Item;
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

import com.googlecode.objectify.Key;

@Controller
@RequestMapping("/item/{itemId}/purchaseorder")
public class PurchaseOrderController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	PurchaseOrderService purchaseOrderService;

	@Autowired
	ItemService itemService;

    
    @RequestMapping(method={RequestMethod.GET}, value="/{id}")
    @ResponseBody
    public ResponseEntity<PurchaseOrder> getById(@PathVariable("itemId") Long itemId, @PathVariable("id") Long id) {
    	PurchaseOrder po = purchaseOrderService.getById(id);
    	
        return new ResponseEntity<PurchaseOrder>(po, HttpStatus.OK);
    }

    @RequestMapping(method={RequestMethod.POST}, value="")
    @ResponseBody
    public ResponseEntity<Long> insert(@PathVariable("itemId") Long itemId, @RequestBody PurchaseOrder purchaseOrder) {    	
    	Item item = itemService.getById(itemId);
    	purchaseOrder.setItem(Key.create(Item.class, item.getId()));
    	Long id = purchaseOrderService.insert(purchaseOrder);
    	
        return new ResponseEntity<Long>(id, HttpStatus.OK);
    }
    
    @RequestMapping(method={RequestMethod.PUT}, value="/{id}")
    @ResponseBody
    public ResponseEntity<Long> update(@PathVariable("itemId") Long itemId, @PathVariable("id") Long id, @RequestBody PurchaseOrder purchaseOrder) {
    	
    	// Trust the ID in the path over the ID in the json
    	// We'll need to add authorization, and it's easiest to filter on the URL
    	purchaseOrder.setId(id);
    	Long newId = purchaseOrderService.update(purchaseOrder);
    	
        return new ResponseEntity<Long>(newId, HttpStatus.OK);
    }
	
}
