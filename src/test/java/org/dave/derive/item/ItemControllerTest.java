package org.dave.derive.item;

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

@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml"})
@WebAppConfiguration
public class ItemControllerTest {

	MockMvc mockMvc;
	
	@InjectMocks
	ItemController itemController;

	@Mock
	ItemService itemService;

	@Before
	public void setUp() {
        MockitoAnnotations.initMocks(this);
		
		mockMvc = MockMvcBuilders.standaloneSetup(itemController).build();
	}

	private Item getTestItem() {
		Item item = new Item();
		item.setId(123456l);
		item.setDescription("Test Item");

		return item;
	}

	@Test
	public void testGetAll() throws Exception {
		List<Item> items = new ArrayList<>();
		
		Item item = getTestItem();
		items.add(item);
		
		when(itemService.getAllItems()).thenReturn(items);
		
		mockMvc.perform(get("/item"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].description", is("Test Item"))
		);
	}
	
	@Test
	public void testGetOne() throws Exception {
		Item item = getTestItem();
		
		when(itemService.getById(Mockito.anyLong())).thenReturn(item);
		
		mockMvc.perform(get("/item/123456"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.description", is("Test Item"))
		);
	}

}
