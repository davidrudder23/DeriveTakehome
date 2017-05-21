package org.dave.derive.item;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ItemControllerTest {

	ItemService itemService;
	
	ItemDAO itemDAO;
	
	private final int NUM_ITEMS = 10;
	
	@Before
	public void setup() {
		itemService = new ItemService();
		ItemDAO itemDAO = mock(ItemDAO.class);
		
		List<Item> items = new ArrayList<>();
		for (int itemNum = 0; itemNum < NUM_ITEMS; itemNum++) {
			Item item = new Item();
			item.id=new Long(itemNum);
			items.add(item);
		}
		when(itemDAO.getAllItems()).thenReturn(items);
		
		itemService.itemDAO = itemDAO;
	}
	
	@Test
	public void testGetAllItems() {
		List<Item> items = itemService.getAllItems();
		assertNotNull(items);
		assertEquals(NUM_ITEMS, items.size());
	}
}
