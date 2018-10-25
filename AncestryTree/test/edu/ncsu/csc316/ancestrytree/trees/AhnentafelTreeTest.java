package edu.ncsu.csc316.ancestrytree.trees;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.ancestrytree.io.AhnentafelReader;

/**
 * Tests ahnentafel tree
 * @author John Ruisi
 *
 */
public class AhnentafelTreeTest {

	/**
	 * Tests tree
	 */
	@Test
	public void testTree() {
		AhnentafelTree a = new AhnentafelTree(AhnentafelReader.getEntry("input/small-ahnentafel.txt"));
		assertNotNull(a);
		a.getLevel();
	}

}
