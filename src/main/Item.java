package main;

import java.time.LocalDate;

public class Item {
	
	enum Units {
		GRAMS,
		OUNCES,
		
		MILLILITRES,
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
		
		if (unit == Units.OUNCES) {
			unit = Units.GRAMS;
			quantity *= 28.35;
		}
		if (unit == Units.FL_OUNCES) {
			unit = Units.MILLILITRES;
			quantity *= 29.57;
		}
		
		this.quantity = quantity;
		this.unit = unit;
		
		this.price = price;
		this.brandName = brandName;
		this.isSale = isSale;
		this.storeName = store;
		this.date = LocalDate.now();
	}
	
	public double getUnitPrice() {
		return this.price/this.quantity;
	}
}
