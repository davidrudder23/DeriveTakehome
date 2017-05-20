package org.dave.derive.purchaseorder;

import java.util.Date;

import org.dave.derive.item.Item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class PurchaseOrder {

	@Id Long id;
	
	String source;
	
	Double quantity;
	
	Date received;

	@JsonIgnore
	Key<Item> item;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Date getReceived() {
		return received;
	}

	public void setReceived(Date received) {
		this.received = received;
	}
	
	public boolean isReceived() {
		return received != null;
	}

	public Key<Item> getItem() {
		return item;
	}

	public void setItem(Key<Item> item) {
		this.item = item;
	}
	
	
}
