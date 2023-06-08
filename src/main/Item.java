package main;

import java.time.LocalDate;

public class Item {
	
	enum Units {
		GRAMS,
		OUNCES,
		
		MILILITRES,
		FL_OUNCES,
		
		EACH
	}
	
	String name;
	double quantity;
	double price;
	Units unit;
	String brandName;
	String storeName;
	boolean isSale;
	LocalDate date;
	
	public Item(String name, double quantity, Units unit, double price, String brandName, boolean isSale, String store) {
		this.name = name;
		this.quantity = quantity;
		this.unit = unit;
		this.price = price;
		this.brandName = brandName;
		this.isSale = isSale;
		this.storeName = store;
		this.date = LocalDate.now();
	}
}
