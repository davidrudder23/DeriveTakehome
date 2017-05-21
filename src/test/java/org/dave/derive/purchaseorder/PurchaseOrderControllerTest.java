package org.dave.derive.purchaseorder;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.appengine.repackaged.com.google.gson.Gson;

@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath:spring/applicationContext.xml" })
@WebAppConfiguration
public class PurchaseOrderControllerTest {

	MockMvc mockMvc;

	@InjectMocks
	PurchaseOrderController purchaseOrderController;

	@Mock
	PurchaseOrderService purchaseOrderService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders.standaloneSetup(purchaseOrderController).build();
	}

	private PurchaseOrder getTestPurchaseOrder() {
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder.setId(123456l);
		purchaseOrder.setSource("Test Source");
		purchaseOrder.setQuantity(1.0);

		return purchaseOrder;
	}

	@Test
	public void testGetOne() throws Exception {
		PurchaseOrder purchaseOrder = getTestPurchaseOrder();

		when(purchaseOrderService.getById(Mockito.anyLong())).thenReturn(purchaseOrder);

		mockMvc.perform(get("/item/1/purchaseorder/123456")).andExpect(status().isOk()).andExpect(jsonPath("$.source", is("Test Source")));
	}

	@Test
	public void testInsert() throws Exception {
		PurchaseOrder item = getTestPurchaseOrder();
		Gson gson = new Gson();
		String json = gson.toJson(item);

		mockMvc.perform(post("/item/1/purchaseorder").contentType("application/json").content(json)).andExpect(status().isOk());

		verify(purchaseOrderService, times(1)).insert(Mockito.any(PurchaseOrder.class));

	}

	@Test
	public void testUpdate() throws Exception {
		PurchaseOrder item = getTestPurchaseOrder();
		item.setSource("This is an updated description");
		Gson gson = new Gson();
		String json = gson.toJson(item);

		mockMvc.perform(put("/item/1/purchaseorder/123456").contentType("application/json").content(json)).andExpect(status().isOk());

		verify(purchaseOrderService, times(1)).update(Mockito.anyLong(), Mockito.any(PurchaseOrder.class));

	}

}
