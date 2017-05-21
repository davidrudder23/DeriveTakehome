package org.dave.derive.item;

import java.io.Closeable;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.googlecode.objectify.ObjectifyService;

public class ItemDAOTest {

	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
	private Closeable closeable;
	
	ItemDAO itemDAO;

	@Before
	public void setUp() {
		itemDAO = new ItemDAO();
		helper.setUp();
		ObjectifyService.factory().begin();
	}
	
	@Test
	public void testGetAllItems() {
		int numItems = 10;
		for (int i = 1; i <= numItems; i++) {
			Item item = new Item();
			item.setId(new Long(i));
			item.setName("Item #"+i);
			item.setDescription("Test item number "+i);

			itemDAO.upsertItem(item);
		}
		
		List<Item> retrievedItems = itemDAO.getAllItems();
		assertNotNull(retrievedItems);
		assertEquals(numItems, retrievedItems.size());
	}

	@Test
	public void testOneItem() {
		int numItems = 10;
		for (int i = 1; i <= numItems; i++) {
			Item item = new Item();
			item.setId(new Long(i));
			item.setName("Item #"+i);
			item.setDescription("Test item number "+i);

			itemDAO.upsertItem(item);
		}
		
		Item retrievedItem = itemDAO.getById(3l);
		assertNotNull(retrievedItem);
		assertEquals(new Long(3), retrievedItem.getId());
	}

}
