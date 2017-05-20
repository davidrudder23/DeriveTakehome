package org.dave.derive.purchaseorder;

import java.util.Date;

import org.dave.derive.item.Item;
import org.dave.derive.item.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import com.googlecode.objectify.Key;

@Component
public class PurchaseOrderService {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
	PurchaseOrderDAO purchaseOrderDAO;
	
	@Autowired
	ItemService itemService;
	
	public PurchaseOrder getById(Long id) {
		return purchaseOrderDAO.getById(id);
	}
	
	public Long insert(PurchaseOrder purchaseOrder) {
		if (purchaseOrder.isReceived()) {
			LOG.warn("Attempted insert of PO that was received on {}", purchaseOrder.getReceived());
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "You may not insert a purchase order which has already been received");
		}
		
		Key<PurchaseOrder> key = purchaseOrderDAO.upsert(purchaseOrder);
		return key.getId();
	}

	public Long update(PurchaseOrder purchaseOrder) {
		PurchaseOrder storedPO = getById(purchaseOrder.getId());
		if (storedPO == null) {
			purchaseOrder.setId(null);
			return insert(purchaseOrder);
		}
		
		// If the received date is set, but it wasn't set, it means
		// the PO is being received.  Increment inventory
		if (purchaseOrder.isReceived() && !storedPO.isReceived()) {
			Item item = itemService.getById(purchaseOrder.getItem().getId());
			
			item.incrementInventory(purchaseOrder.getQuantity());
			itemService.update(item);
		}
		
		// Similarly, if the received date is unset, but it was previously set
		// then the PI is being un-received.  Decrement inventory
		if (purchaseOrder.isReceived() && !storedPO.isReceived()) {
			Item item = itemService.getById(purchaseOrder.getItem().getId());
			
			item.decrementInventory(purchaseOrder.getQuantity());
			itemService.update(item);
		}
		
		Key<PurchaseOrder> key = purchaseOrderDAO.upsert(purchaseOrder);
		return key.getId();
	}

}
