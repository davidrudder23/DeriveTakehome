package org.dave.derive.salesorder;

import java.util.Date;

import org.dave.derive.boot.KeyToStringSerializer;
import org.dave.derive.item.Item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Parent;

@Entity
public class SalesOrderLine {

	@Id
	Long id;
	
	@Parent Key<SalesOrder> salesOrder;
	
	@JsonSerialize(using=KeyToStringSerializer.class, as=String.class)
	Key<Item> item;
	
	Double quantity;
	
	@JsonIgnore
	Date dateCreated;
	
	@JsonIgnore
	Date lastModified;
	
	public String toString() {
		return "item:"+(item==null?"null":item.getId())+" qty:"+quantity;
	}
}
