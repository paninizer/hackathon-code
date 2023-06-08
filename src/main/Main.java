package main;

/**
 * @author tluo9638, ljensen0762
 */

import java.io.*;
import java.util.*;

import main.Item.Units;

public class Main {

	/**
	 * @param args
	 * 
	 * @param PUBLIC
	 * BufferedReader
	 * StringTokenizer
	 * 
	 * @param PRIVATE
	 * global variables
	 */
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Item> items = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("  _____      _          _                 _    \r\n"
				 + " |  __ \\    (_)        | |               | |   \r\n"
				 + " | |__) | __ _  ___ ___| |__   ___   ___ | | __\r\n"
				 + " |  ___/ '__| |/ __/ _ \\ '_ \\ / _ \\ / _ \\| |/ /\r\n"
				 + " | |   | |  | | (_|  __/ |_) | (_) | (_) |   < \r\n"
				 + " |_|   |_|  |_|\\___\\___|_.__/ \\___/ \\___/|_|\\_\\\r\n"
				 + "                                               \r\n"
				 + "                                               ");
		
		System.out.println("\n\n");
		
		
		String[] options = {"add", "display"};
		String[] descriptions = {"Add an item", "Display all items"};
		
		while (true) {
			int returned = handleSelection("Choose a command: ", options, descriptions);
			
			handleSelection(options[returned]); 
		}
	}
	
	public static int handleSelection(String selectMsg, String selectMethod, int length) throws Exception {
		
		System.out.print(selectMsg);
		
		boolean isValidInput = false;
		int selector = 0; // scope level declaration
		
		if (selectMethod.equals("number")) {
			while (!isValidInput) {
				
				String input = br.readLine(); // read input
				
				while (!isInteger(input)) { // if not int
					System.out.println();
					System.out.println("====================EXCEPTION===================");
					System.out.println("|           Input must be a number!            |");
					System.out.println("====================EXCEPTION===================");
					System.out.println();
					System.out.print(selectMsg);
					input = br.readLine();
				}
				selector = Integer.parseInt(input);
				
				if (selector<0 || selector>(length-1)) { // if not valid
					System.out.println();
					System.out.println("====================EXCEPTION===================");
					System.out.println("|     Input must be in range 0 < input < "+ (length-1) + "     |");
					System.out.println("====================EXCEPTION===================");
					System.out.println();
					System.out.print(selectMsg);					
				} else isValidInput = true;
			}
			
			return selector;
			
		} else if (selectMethod.equals("character")) {
			while (!isValidInput) {
				String input = br.readLine(); // read input
				
				while (!isCharacter(input)) { // if not int
					System.out.println();
					System.out.println("====================EXCEPTION===================");
					System.out.println("|          Input must be a character!          |");
					System.out.println("====================EXCEPTION===================");
					System.out.println();
					System.out.print(selectMsg);
					input = br.readLine();
				}
				selector = (int) input.charAt(0)-65;
				if (selector<0 || selector>(length-1)) { // if not valid
					System.out.println();
					System.out.println("====================EXCEPTION===================");
					System.out.println("|   Input must be between A and "+ ((char)(65+length-1)) + " (inclusive)  |");
					System.out.println("====================EXCEPTION===================");
					System.out.println();
					System.out.print(selectMsg);					
				} else isValidInput = true;
			}
			
			return selector;
			
		} else if (selectMethod.equals("yes/no")) {
			while (!isValidInput) {
				String input = br.readLine(); // read input
				
				while (!isCharacter(input)) { // if not int
					System.out.println();
					System.out.println("====================EXCEPTION===================");
					System.out.println("|          Input must be a character!          |");
					System.out.println("====================EXCEPTION===================");
					System.out.println();
					System.out.print(selectMsg);
					input = br.readLine();
				}
				selector = (int) input.charAt(0)-65;
				if (selector<0 || selector>(length-1)) { // if not valid
					System.out.println();
					System.out.println("====================EXCEPTION===================");
					System.out.println("|   Input must be between A and "+ ((char)(65+length-1)) + " (inclusive)  |");
					System.out.println("====================EXCEPTION===================");
					System.out.println();
					System.out.print(selectMsg);					
				} else isValidInput = true;
			}
			
			return selector;
			
		}
		
		throw new Exception("Params incorrect.");
	}
	
	public static int handleSelection(String selectMsg, String[] options, String[] description) throws Exception {
		
		boolean isValidInput = false;
		int selector = 0; // scope level declaration
		while (!isValidInput) {
			System.out.println("\nAvailable Options: ");
			for (int i=0; i< options.length; i++) {
				System.out.println("--  " + options[i] + " = " + description[i]);
			}
			System.out.println();
			System.out.print(selectMsg);
		
			String input = br.readLine(); // read input
			
			for (int i=0; i<options.length; i++) {
				if (options[i].equals(input.toLowerCase())) {
					selector = i;

					return selector;
				}
			}
			
			System.out.println("Invalid input, please make sure your input matches one of the options and try again.");
		}
		
		return selector;
	}
	
	public static String handleSelection(String selectMsg, boolean canConfirm) throws IOException {
		
		System.out.print(selectMsg);
		String input = br.readLine();
		
		if (canConfirm) {
			do {
				System.out.print("Do you confirm? (yes/no): ");
				String confirm = br.readLine().toLowerCase();
				
				if (confirm.equals("no")) {
					return handleSelection(selectMsg, true);
				} else if (confirm.equals("yes")) {
					return input;
				} else {
					System.out.println("Invalid input. Please input yes or no.");
				}
			} while (true);
		}
		
		throw new AssertionError();
	}
	
	public static void handleSelection(String selectId) throws IOException {
		switch (selectId) {
			case "add" :
				addItem();
				break;
			case "display" :
				displayItems();
				break;
			default:
				break;
		}
	}
	
	public static Units handleQuantity(String unit) {
		switch (unit) {
			case "ml" :
				return Units.MILLILITRES;
			case "l" : 
				return Units.LITRES;
			case "lb" :
				return Units.POUNDS;
			case "oz" :
				return Units.OUNCES;
			case "fl.oz" :
				return Units.FLUID_OUNCES;
			case "gal" :
				return Units.GALLONS;
			case "pt" :
				return Units.PINTS;
			case "qt" :
				return Units.QUARTS;
			case "ea" :
				return Units.EACH;
			
			default :
				throw new AssertionError();
		}
	}
	
	public static void addItem() throws IOException {
		String[] options = {"ml", "l", "g", "kg", "lb", "oz", "fl.oz", "gal", "pt", "qt", "ea"};
		String[] descriptions = {"mililitres", "litres", "grams", "kilograms", "pounds", "ounces", "fluid ounces", "gallons", "pints", "quarts", "each (no unit)"};

		String name = handleSelection("Please input the item name: ", true);
		boolean cont = false;
		double parsedQuantity = 0.0;
		Units unit = null;
		double price = 0;
		
		do {
			System.out.println("Available Units: "); 
			for (int i=0; i< options.length; i++) {
				System.out.println("--  " + options[i] + " = " + descriptions[i]);
			}
			String quantity = handleSelection("Please input the item quantity and unit, separated by a space: ", true);
			cont = Item.parseQuantity(quantity);
			
			if (!cont) {
				System.out.println("Invalid input! Please input the item quantity and unit, separated by a space according to the legends.");
				continue;
			}
			String[] splitted = quantity.split(" ");
			parsedQuantity = Double.parseDouble(splitted[0]);	
			
			unit = handleQuantity(splitted[1]);
		} while (!cont);
		
		cont = false;
		do {
			System.out.print("Enter the price, numbers only: ");
			String input = br.readLine();
			
			try {
				price = Double.parseDouble(input);
			} catch (java.lang.NumberFormatException e) {
				System.out.println("Invalid input! Please enter the only numbers!");
				continue;
			}
			
			if (price<=0) {
				System.out.println("Invalid input! Please enter a number greater than 0!");
				continue;
			}
			
			cont = true;
		} while (!cont);
		
		String brandName = handleSelection("Please input the brand name: ", true);
		String storeName = handleSelection("Please input the store name: ", true);
		boolean isSale = false;
		
		cont = false;
		do {
			System.out.print("Please input if this item is on sale (yes/no): ");
			String confirm = br.readLine();
			if (confirm.equals("no")) {
				break;
			} else if (confirm.equals("yes")) {
				isSale = true;
				cont = true;
			} else {
				System.out.println("Invalid input. Please input yes or no.");
			}
		} while (!cont);
		
		String date = "";
		
		cont = false;
		System.out.print("Input the date of purchase in YYYY/MM/DD format, or just press enter if it's the current date: ");
		date = br.readLine();
		
		items.add(new Item(name, parsedQuantity, unit, price, brandName, isSale, storeName, date));
	}
	
	public static void displayItems() throws IOException {
		String leftAlignFormat = "| %-20s | %-19s | %n";
		System.out.println("=====================LIST=====================");
		System.out.format(leftAlignFormat, "Item", "Quantity");
		System.out.println("==============================================");
		for (Item item : items) {
			if (item.unit == Units.EACH) {
				System.out.format(leftAlignFormat, item.name, (int)item.quantity);
			} else {
				String unit = item.unit.toString().toLowerCase();
				unit = unit.replace("_", " ");
				System.out.format(leftAlignFormat, item.name, item.quantity + " " + unit);
			}
			System.out.println("==============================================");
		}
	}
	
	public static boolean isInteger(String str) {
	    if (str == null) {
	        return false;
	    }
	    int length = str.length();
	    if (length == 0) {
	        return false;
	    }
	    int i = 0;
	    if (str.charAt(0) == '-') {
	        if (length == 1) {
	            return false;
	        }
	        i = 1;
	    }
	    for (; i < length; i++) {
	        char c = str.charAt(i);
	        if (c < '0' || c > '9') {
	            return false;
	        }
	    }
	    return true;
	}

	public static boolean isDecimal(String str) {
	    if (str == null) {
	        return false;
	    }
	    int length = str.length();
	    if (length == 0) {
	        return false;
	    }
	    int i = 0;
	    if (str.charAt(0) == '-') {
	        if (length == 1) {
	            return false;
	        }
	        i = 1;
	    }
	    for (; i < length; i++) {
	        char c = str.charAt(i);
	        if (c < '0' || c > '9') {
	            return false;
	        }
	    }
	    return true;
	}
	
	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}
	
	public static boolean isCharacter(String str) {
		if (str.length() > 1) return false;
		char character = str.charAt(0);
		
		if (!Character.isAlphabetic(character)) return false;
		
		return true;
	}

}
