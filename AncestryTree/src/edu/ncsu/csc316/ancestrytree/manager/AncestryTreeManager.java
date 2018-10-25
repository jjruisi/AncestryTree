package edu.ncsu.csc316.ancestrytree.manager;

import edu.ncsu.csc316.ancestrytree.data.AhnentafelEntry;
import edu.ncsu.csc316.ancestrytree.data.Person;
import edu.ncsu.csc316.ancestrytree.io.AhnentafelReader;
import edu.ncsu.csc316.ancestrytree.io.TraversalReader;
import edu.ncsu.csc316.ancestrytree.list.ArrayList;
import edu.ncsu.csc316.ancestrytree.trees.AhnentafelTree;
import edu.ncsu.csc316.ancestrytree.trees.TraversalTree;

/**
 * Manager for the ancestry tree
 * @author John Ruisi
 *
 */
public class AncestryTreeManager {

	//Preorder traversal
	private ArrayList<Person> preOrder;
	//Postorder traversal
	private ArrayList<Person> postOrder;
	//Level order traversal
	private ArrayList<AhnentafelEntry> level;
	//Traversal tree
	private TraversalTree tt;
	//Ahnentafel tree
	private AhnentafelTree at;
	
	/**
	 * Constructor to initialize an instance of your AncestryTreeManager object
	 * @param preOrderFilePath the path to the file that contains the preOrder traversal
	 * @param postOrderFilePath the path to the file that contains the postOrder traversal
	 */
	public AncestryTreeManager(String preOrderFilePath, String postOrderFilePath) {
	    level = null;
	    preOrder = TraversalReader.getTraversal(preOrderFilePath);
	    postOrder = TraversalReader.getTraversal(postOrderFilePath);
	    tt = new TraversalTree(preOrder, postOrder);
	    at = null;
	}

	/**
	 * Constructor to initialize an instance of your AncestryTreeManager object
	 * @param ahnentafelFilePath the path to the file that contains the ahnentafel
	 */
	public AncestryTreeManager(String ahnentafelFilePath) {
	    preOrder = null; postOrder = null;
	    level = AhnentafelReader.getEntry(ahnentafelFilePath);
	    at = new AhnentafelTree(level);
	}

	/**
	 * Returns the level-order traversal for the tree
	 * as a String in the format:
	 * LevelOrder[lastName, firstName; lastName2, firstName2]
	 * @return the level-order traversal for the tree
	 */
	public String getLevelOrder() {
		if (preOrder == null && postOrder == null) {
			return levelAhnentafel();
		} else {
			return null;
		}
	}

	/**
	 * Returns a description of the relationship between
	 * two individuals in the tree, formatted as:
	 * [nameA] is [nameB]'s [relationship]
	 * @param nameA the first person to find in the tree
	 * @param nameB the second person to find in the tree
	 * @return a description of how the two people are related
	 */
	public String getRelationship(String nameA, String nameB) {
		return null;
	}

	/**
	 * Returns a description of the relationship between
	 * two individuals in the tree, formatted as:
	 * [name] is [root]'s [relationship]
	 * @param name the person to find in the tree
	 * @return a description of how the person is related to the person at the root of the tree
	 */
	public String getRelationship(String name) {
		return null;
	}
	
	/**
	 * Gets level ahnentafel string
	 * @return the level order string
	 */
	private String levelAhnentafel() {
		StringBuilder str = new StringBuilder();
		str.append("LevelOrder[");
		
		for (int i = 0; i < level.size(); i++) {
			if (i == level.size() - 1) {
				str.append(level.get(i).toString());
				continue;
			}
			str.append(level.get(i).toString());
			str.append("; ");
		}
		
		str.append("]");
		return str.toString();
	}
	
	/**
	 * Gets the entry
	 * @return level the entry
	 */
	public ArrayList<AhnentafelEntry> getEntry() {
		return level;
	}
	
	/**
	 * Gets pre order 
	 * @return preorder the preorder
	 */
	public ArrayList<Person> getPre() {
		return preOrder;
	}
	
	/**
	 * gets the post order
	 * @return postOrder the post order
	 */
	public ArrayList<Person> getPost() {
		return postOrder;
	}
	
	/**
	 * gets the traversal tree
	 * @return tt the tree
	 */
	public TraversalTree getTraversal() {
		return tt;
	}
	
	/**
	 * gets the ahnetafel tree
	 * @return at the tree
	 */
	public AhnentafelTree getAhnen() {
		return at;
	}
}
