package org.dave.derive.item;

import java.util.List;

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
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @RequestMapping(method={RequestMethod.GET}, value="")
    @ResponseBody
    public ResponseEntity<List<Item>> getAllItems() {
    	List<Item> items = itemService.getAllItems();
    	
        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }
    
    @RequestMapping(method={RequestMethod.GET}, value="/{id}")
    @ResponseBody
    public ResponseEntity<Item> getById(@PathVariable("id") Long id) {
    	Item item = itemService.getById(id);
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    
    
    @RequestMapping(method={RequestMethod.POST}, value="")
    @ResponseBody
    public ResponseEntity<Long> InsertItem(@RequestBody Item item) {
    	Long id = itemService.insert(item);
    	
        return new ResponseEntity<Long>(id, HttpStatus.OK);
    }

}
