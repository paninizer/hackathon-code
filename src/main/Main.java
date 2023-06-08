package main;

/**
 * @author tluo9638, ljensen0762
 */

import java.io.*;
import java.util.*;

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
		
		
		int returned = handleSelection("Choose a command (A-B): ", "character", 2);
		
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
				selector = (int)input.charAt(0) - 65;
				
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
	
	public static int handleSelection(String selectMsg, String[] options) throws Exception {
		
		System.out.println("Available Options: ");
		for (int i=0; i< options.length; i++) {
			System.out.println("--  " + options[i]);
		}
		
		System.out.print(selectMsg);
		
		boolean isValidInput = false;
		int selector = 0; // scope level declaration
		while (!isValidInput) {
			String input = br.readLine(); // read input
			
			Arrays.asList(options).contains(input);
		}
		
		
		throw new Exception("Params incorrect.");
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
	
	public static boolean isCharacter(String str) {
		if (str.length() > 1) return false;
		char character = str.charAt(0);
		
		if (!Character.isAlphabetic(character)) return false;
		
		return true;
	}

}
