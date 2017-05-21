package org.dave.derive.salesorder;

import static com.googlecode.objectify.ObjectifyService.ofy;
import static com.googlecode.objectify.ObjectifyService.register;

import java.util.List;

import org.springframework.stereotype.Component;

import com.googlecode.objectify.Key;

@Component
public class SalesOrderDAO {
	static {
		register(SalesOrder.class);
	}
	
	public SalesOrder getById(Long id) {
		return ofy().load().type(SalesOrder.class).id(id).now();
	}
	
	public List<SalesOrder> getAll() {
		return ofy().load().type(SalesOrder.class).list();
	}
	
	public Key<SalesOrder> upsert(SalesOrder salesOrder) {
		Key<SalesOrder> key = ofy().save().entity(salesOrder).now();
		return key;
	}
}
