package edu.ncsu.csc316.ancestrytree.data;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests person class
 * @author John Ruisi
 *
 */
public class PersonTest {

	/**
	 * Tests constructor
	 */
	@Test
	public void testPerson() {
		Person p = new Person("John", "Ruisi", "M");
		assertEquals(p.getFirst(), "John");
		assertEquals(p.getLast(), "Ruisi");
		assertEquals(p.getSex(), "M");
		assertEquals(p.toString(), "Ruisi, John");
		Person p1 = new Person("John", "Ruisi", "M");
		assertTrue(p.equals(p1));
		Person p2 = new Person("John", "asdf", "M");
		assertFalse(p.equals(p2));
	}

}
