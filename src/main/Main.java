/**
 * 
 */
package main;

/**
 * @author tluo9638, ljensen0762
 *
 */

import java.io.*;
import java.util.*;
import org.json.*;

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
	static File save = new File("saves/output.json");
	static StringTokenizer st;
	
	//static JSONObject saveObject = new JSONObject();
	static ArrayList<Item> allItems = new ArrayList<>();
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(save.getAbsolutePath());
	}

}
