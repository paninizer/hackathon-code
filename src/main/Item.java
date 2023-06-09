package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Item {
	
	enum Units {
		KILOGRAMS,
		GRAMS,
		
		POUNDS,
		OUNCES,
		
		LITRES,
		MILLILITRES,
		
		GALLONS,
		QUARTS,
		PINTS,
		FLUID_OUNCES,
		
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
	
		/*
		if (unit == Units.OUNCES) {
			unit = Units.GRAMS;
			quantity *= 28.35;
		}
		if (unit == Units.FLUID_OUNCES) {
			unit = Units.MILLILITRES;
			quantity *= 29.57;
		}*/
		
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
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy");
			d = LocalDate.parse(date, formatter);
		}
		
		this.date = d;
	}
	
	public double getUnitPrice() {
		return this.price/this.quantity;
	}
	
	public static boolean parseQuantity(String quantity) {
		String[] suffixes = {"ml", "l", "g", "kg", "lb", "oz", "fl.oz", "gal", "pt", "qt", "ea"};
		
		String[] parsing = quantity.split("\s");
		boolean found = false;
		
		//System.out.println(parsing[1]);
		
		for (int i=0; i<suffixes.length; i++) {
			if (suffixes[i].equals(parsing[1])) {
				found = true;
				break;
			}
		}
		
		if (!found) return false;
		
		try {
			Double.parseDouble(parsing[0]);
		} catch (java.lang.NumberFormatException e) {
			System.out.println("point 2");
			return false;
		}
		
		return true;
	}
}
