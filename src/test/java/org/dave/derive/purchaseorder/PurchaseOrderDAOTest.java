package org.dave.derive.purchaseorder;

import java.io.Closeable;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.googlecode.objectify.ObjectifyService;

public class PurchaseOrderDAOTest {

	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
	private Closeable closeable;
	
	PurchaseOrderDAO purchaseOrderDAO;

	@Before
	public void setUp() {
		purchaseOrderDAO = new PurchaseOrderDAO();
		helper.setUp();
		ObjectifyService.factory().begin();
	}
	
	/*
	@Test
	public void testGetAllPurchaseOrders() {
		int numPurchaseOrders = 10;
		for (int i = 1; i <= numPurchaseOrders; i++) {
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			purchaseOrder.setId(new Long(i));
			purchaseOrder.setSource("PurchaseOrder #"+i);
			purchaseOrder.setQuantity(new Double(i));

			purchaseOrderDAO.upsert(purchaseOrder);
		}
		
		List<PurchaseOrder> retrievedPurchaseOrders = purchaseOrderDAO.getAllPurchaseOrders();
		assertNotNull(retrievedPurchaseOrders);
		assertEquals(numPurchaseOrders, retrievedPurchaseOrders.size());
	}*/

	@Test
	public void testOnePurchaseOrder() {
		int numPurchaseOrders = 10;
		for (int i = 1; i <= numPurchaseOrders; i++) {
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			purchaseOrder.setId(new Long(i));
			purchaseOrder.setSource("PurchaseOrder #"+i);
			purchaseOrder.setQuantity(new Double(i));

			purchaseOrderDAO.upsert(purchaseOrder);
		}
		
		PurchaseOrder retrievedPurchaseOrder = purchaseOrderDAO.getById(3l);
		assertNotNull(retrievedPurchaseOrder);
		assertEquals(new Long(3), retrievedPurchaseOrder.getId());
	}

}
