package edu.ncsu.csc316.ancestrytree.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc316.ancestrytree.data.AhnentafelEntry;
import edu.ncsu.csc316.ancestrytree.list.ArrayList;

/**
 * Reads ahnentafel files
 * @author John Ruisi
 *
 */
public class AhnentafelReader {

	/**
	 * reads input and creates an array list of ahnentafel entries
	 * @param fileName the ahnentafel file
	 * @return list the list of ahnentafel entries
	 */
	public static ArrayList<AhnentafelEntry> getEntry(String fileName) {
		
		ArrayList<AhnentafelEntry> list = new ArrayList<AhnentafelEntry>();
		Scanner scan;
		try {
			scan = new Scanner(new FileInputStream(fileName), "UTF8");
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("FNF");
		}
		
		while (scan.hasNextLine()) {
			int num = scan.nextInt();
			String first = scan.next();
			String last = scan.next();
			
			AhnentafelEntry p = new AhnentafelEntry(num, first, last);
			list.add(p);
		}
		
		scan.close();
		return list;
	}
}
