package edu.ncsu.csc316.ancestrytree.trees;

import edu.ncsu.csc316.ancestrytree.data.AhnentafelEntry;
import edu.ncsu.csc316.ancestrytree.list.ArrayList;

/**
 * Creates tree from an ahnentafel file
 * @author John Ruisi
 *
 */
public class AhnentafelTree {
	
	//List of entries
	private ArrayList<AhnentafelEntry> list;
	//Root of the tree
	private AhnentafelEntry root;

	/**
	 * Cosntructor that uses a array of entries to create tree
	 * @param a the entry array list
	 */
	public AhnentafelTree(ArrayList<AhnentafelEntry> a) {
		this.list = a;
		this.root = list.get(0);
		buildTree();
	}
	
	/**
	 * Builds tree using the ahnentafel entry array list
	 */
	public void buildTree() {
		ArrayList<AhnentafelEntry> queue = new ArrayList<AhnentafelEntry>();
		queue.add(root);
		AhnentafelEntry current;
		int count = 0;
		
		for (int i = 1; i < list.size() ; i++) {
			AhnentafelEntry temp = list.get(i);
			current = queue.remove(0);
			if (count == 0) {
				current.setFather(temp);
				count++;
			} else {
				current.setMother(temp);
				count = 0;
			}
			queue.add(temp);
		}
	}
	
	/**
	 * Gets the level order of the tree
	 * @return the level order of the string
	 */
	public String getLevel() {
		StringBuilder a = new StringBuilder("LevelOrder[");
		
		ArrayList<AhnentafelEntry> levelQ = new ArrayList<AhnentafelEntry>();
		ArrayList<AhnentafelEntry> printQ = new ArrayList<AhnentafelEntry>();
		
		levelQ.add(root);
		
		while(!levelQ.isEmpty()) {
			AhnentafelEntry temp = levelQ.remove(0);
			if (temp != null) {
				printQ.add(temp);
			}
			if (temp.getFather() != null) {
				levelQ.add(temp.getFather());
			}
			if (temp.getMother() != null) {
				levelQ.add(temp.getMother());
			}
		}
		
		while (!printQ.isEmpty()) {
			AhnentafelEntry temp = printQ.remove(0);
			if (printQ.size() != 1) {
				a.append(temp.getLast() + ", " + temp.getFirst() + "; ");
			} else {
				a.append(temp.getLast() + ", " + temp.getFirst() + "]");
			}
		}
		return a.toString();
	}
}
