package edu.ncsu.csc316.ancestrytree.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc316.ancestrytree.data.Person;
import edu.ncsu.csc316.ancestrytree.list.ArrayList;

/**
 * Reads pre or post order traversal files
 * @author John Ruisi
 *
 */
public class TraversalReader {

	/**
	 * reads input and creates array list of person objects
	 * @param fileName the traversal file
	 * @return list the array list of persons
	 */
	public static ArrayList<Person> getTraversal(String fileName) {
		
		ArrayList<Person> list = new ArrayList<Person>();
		Scanner scan;
		try {
			scan = new Scanner(new FileInputStream(fileName), "UTF8");
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("FNF");
		}
		
		while (scan.hasNextLine()) {
			String first = scan.next();
			String last = scan.next();
			String sex = scan.next();
			
			Person p = new Person(first, last, sex);
			list.add(p);
		}
		
		scan.close();
		return list;
	}
}
