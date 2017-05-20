package org.dave.derive.item;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemService {
    private final Logger LOG = LoggerFactory.getLogger(getClass().getName());
    
    @Autowired
    ItemDAO itemDAO;
	
	public List<Item> getAllItems() {
		return itemDAO.getAllItems();
	}
	
	public Item getById(Long id) {
		return itemDAO.getById(id);
	}
	
	public Long insert(Item item) {
		return itemDAO.upsertItem(item).getId();
	}
	
	public Long update(Item item) {
		return itemDAO.upsertItem(item).getId();
	}

}
