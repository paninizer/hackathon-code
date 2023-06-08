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
	
	public Item(String name, double quantity, Units unit, double price, String brandName, boolean isSale, String store, String date) {
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
		
		LocalDate d;
		
		if (date.equals("")) {
			d = LocalDate.now();
		} else {
			d = LocalDate.parse(date);
		}
		
		this.date = d;
	}
	
	public double getUnitPrice() {
		return this.price/this.quantity;
	}
	
	public static boolean parseQuantity(String quantity) {
		String[] suffixes = {"g", "oz", "fl oz", "ml", "ea"};
		
		String[] parsing = quantity.split(" ");
		for (int i=0; i<suffixes.length; i++) {
			if (!parsing[1].endsWith(suffixes[i])) return false;
		}
		
		if (!Main.isNumeric(parsing[0])) return false;
		
		return true;
	}
}
