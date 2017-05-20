package org.dave.derive.item;

import static com.googlecode.objectify.ObjectifyService.ofy;
import static com.googlecode.objectify.ObjectifyService.register;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.googlecode.objectify.Key;

@Component
public class ItemDAO {

	 private final Logger LOG = LoggerFactory.getLogger(getClass().getName());
		static {
			register(Item.class);
		}
		
		public List<Item> getAllItems() {
			List<Item> items = ofy().load().type(Item.class).list();
			return items;
		}
		
		public Item getById(Long id) {
			return ofy().load().type(Item.class).id(id).now();
		}
		
		public Key<Item> upsertItem(Item item) {
			Key<Item> key = ofy().save().entity(item).now();
			LOG.debug("key={}", key);
			return key;
		}
}
