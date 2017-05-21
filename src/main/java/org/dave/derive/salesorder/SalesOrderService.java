package org.dave.derive.salesorder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.googlecode.objectify.Key;

@Component
public class SalesOrderService {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
	SalesOrderDAO salesOrderDAO;
	
	public SalesOrder getById(Long id) {
		return salesOrderDAO.getById(id);
	}
	
	public Long insert(SalesOrder salesOrder) {
		LOG.error("Inserting sales order {}", salesOrder);
		//Key<SalesOrder> key = salesOrderDAO.upsert(salesOrder);
		return salesOrder.getId();
	}

	public Long update(SalesOrder salesOrder) {
		Key<SalesOrder> key = salesOrderDAO.upsert(salesOrder);
		return key.getId();
	}

}
