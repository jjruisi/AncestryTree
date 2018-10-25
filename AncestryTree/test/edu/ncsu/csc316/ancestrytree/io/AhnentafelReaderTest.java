package edu.ncsu.csc316.ancestrytree.io;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.ancestrytree.data.AhnentafelEntry;
import edu.ncsu.csc316.ancestrytree.list.ArrayList;

/**
 * Tests reader
 * @author John Ruisi
 *
 */
public class AhnentafelReaderTest {

	/**
	 * tests reading file
	 */
	@Test
	public void testLevel() {
		AhnentafelReader b = new AhnentafelReader();
		assertNotNull(b);
		
		ArrayList<AhnentafelEntry> a;
		a = AhnentafelReader.getEntry("input/small-ahnentafel.txt");
		assertEquals(a.get(0).getFirst(), "Billy");
	}

	/**
	 * Tests file not found
	 */
	@Test
	public void testFNF() {
		try {
			AhnentafelReader.getEntry("yes.txt");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "FNF");
		}
		
	}
}
