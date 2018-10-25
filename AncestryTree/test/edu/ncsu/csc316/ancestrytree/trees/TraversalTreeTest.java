package edu.ncsu.csc316.ancestrytree.trees;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.ancestrytree.data.Person;
import edu.ncsu.csc316.ancestrytree.io.TraversalReader;
import edu.ncsu.csc316.ancestrytree.list.ArrayList;

/**
 * Tests traversal tree
 * @author John Ruisi
 *
 */
public class TraversalTreeTest {

	/**
	 * Tests constructor
	 */
	@Test
	public void testConstructor() {
		ArrayList<Person> pre = TraversalReader.getTraversal("input/preOrder.txt");
		ArrayList<Person> post = TraversalReader.getTraversal("input/postOrder.txt");
		TraversalTree t = new TraversalTree(pre, post);
		assertNotNull(t.getPreorder());
		assertNotNull(t.getPostorder());
		
		assertEquals(t.getRoot().getData().getFirst(), "Bill");
		assertNull(t.getRoot().getParent());
		assertNotNull(t.getRoot().getChildren());
	}

}
