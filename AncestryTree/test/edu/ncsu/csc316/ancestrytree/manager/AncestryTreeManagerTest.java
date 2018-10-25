package edu.ncsu.csc316.ancestrytree.manager;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests ancestry manager
 * @author John Ruisi
 *
 */
public class AncestryTreeManagerTest {

	/**
	 * Tests traversal
	 */
	@Test
	public void testTraversal() {
		AncestryTreeManager a = new AncestryTreeManager("input/small-preorder.txt", "input/small-postorder.txt");
		assertNull(a.getEntry());
		a.getTraversal();
	}
	
	/**
	 * Tests ahnentafel
	 */
	@Test
	public void testLevel() {
		AncestryTreeManager a = new AncestryTreeManager("input/small-ahnentafel.txt");
		assertNull(a.getPre());
		assertNull(a.getPost());
		a.getLevelOrder();
		a.getAhnen();
	}
	
	/**
	 * Tests constructor
	 */
	@Test public void test() {
		AncestryTreeManager a = new AncestryTreeManager("input/small-preorder.txt", "input/small-postorder.txt");
		assertNull(a.getRelationship(""));
		assertNull(a.getRelationship("", ""));
	}
}
