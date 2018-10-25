package edu.ncsu.csc316.ancestrytree.data;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests entry
 * @author John Ruisi
 *
 */
public class AhnentafelEntryTest {

	/**
	 * tests entry
	 */
	@Test
	public void testEntry() {
		AhnentafelEntry a = new AhnentafelEntry(1, "John", "Ruisi");
		assertEquals(a.getNum(), 1);
		assertEquals(a.getFirst(), "John");
		assertEquals(a.getLast(), "Ruisi");
		assertEquals(a.toString(), "Ruisi, John");
	}

}
