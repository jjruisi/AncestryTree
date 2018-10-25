package edu.ncsu.csc316.ancestrytree.io;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.ancestrytree.data.Person;
import edu.ncsu.csc316.ancestrytree.list.ArrayList;

/**
 * Tests reader
 * @author John Ruisi
 *
 */
public class TraversalReaderTest {

	/**
	 * Tests pre order
	 */
	@Test
	public void testPreorder() {
		TraversalReader a = new TraversalReader();
		assertNotNull(a);
		
		ArrayList<Person> p;
		p = TraversalReader.getTraversal("input/preOrder.txt");
		assertEquals(p.get(0).getFirst(), "Bill");
		assertEquals(p.get(1).getFirst(), "Bob");
	}
	
	/**
	 * Test post order
	 */
	@Test
	public void testPostorder() {
		ArrayList<Person> p;
		p = TraversalReader.getTraversal("input/postOrder.txt");
		assertEquals(p.get(0).getFirst(), "Bobby");
		assertEquals(p.get(1).getFirst(), "Betsy");
	}
	
	/**
	 * Tests file not found
	 */
	@Test
	public void testFNF() {
		try {
			TraversalReader.getTraversal("yes.txt");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "FNF");
		}
		
	}
}
