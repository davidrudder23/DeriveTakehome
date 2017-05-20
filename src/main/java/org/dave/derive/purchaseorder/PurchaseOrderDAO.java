package org.dave.derive.purchaseorder;

import static com.googlecode.objectify.ObjectifyService.ofy;
import static com.googlecode.objectify.ObjectifyService.register;

import java.util.List;

import org.springframework.stereotype.Component;

import com.googlecode.objectify.Key;

@Component
public class PurchaseOrderDAO {
	static {
		register(PurchaseOrder.class);
	}
	
	public PurchaseOrder getById(Long id) {
		return ofy().load().type(PurchaseOrder.class).id(id).now();
	}
	
	public List<PurchaseOrder> getAll() {
		return ofy().load().type(PurchaseOrder.class).list();
	}
	
	public Key<PurchaseOrder> upsert(PurchaseOrder purchaseOrder) {
		Key<PurchaseOrder> key = ofy().save().entity(purchaseOrder).now();
		return key;
	}
}
