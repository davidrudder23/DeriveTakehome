package org.dave.derive.purchaseorder;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PurchaseOrderServiceTest {

	PurchaseOrderService purchaseOrderService;
	
	PurchaseOrderDAO purchaseOrderDAO;
	
	private final int NUM_ITEMS = 10;
	
	/*
	@Before
	public void setup() {
		purchaseOrderService = new PurchaseOrderService();
		PurchaseOrderDAO purchaseOrderDAO = mock(PurchaseOrderDAO.class);
		
		List<PurchaseOrder> purchaseOrders = new ArrayList<>();
		for (int purchaseOrderNum = 0; purchaseOrderNum < NUM_ITEMS; purchaseOrderNum++) {
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			purchaseOrder.id=new Long(purchaseOrderNum);
			purchaseOrders.add(purchaseOrder);
		}
		when(purchaseOrderDAO.getAllPurchaseOrders()).thenReturn(purchaseOrders);
		
		purchaseOrderService.purchaseOrderDAO = purchaseOrderDAO;
	}
	
	@Test
	public void testGetAllPurchaseOrders() {
		List<PurchaseOrder> purchaseOrders = purchaseOrderService.getAllPurchaseOrders();
		assertNotNull(purchaseOrders);
		assertEquals(NUM_ITEMS, purchaseOrders.size());
	}*/
}
