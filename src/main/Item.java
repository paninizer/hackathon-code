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
	boolean isSale;
	LocalDate date;
	
	public Item(String name, double quantity, Units unit, double price, String brandName, boolean isSale) {
		this.name = name;
		this.quantity = quantity;
		this.unit = unit;
		this.price = price;
		this.brandName = brandName;
		this.isSale = isSale;
		this.date = LocalDate.now();
	}
}
