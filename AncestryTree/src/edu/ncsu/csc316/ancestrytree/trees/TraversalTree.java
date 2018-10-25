package edu.ncsu.csc316.ancestrytree.trees;

import edu.ncsu.csc316.ancestrytree.data.Person;
import edu.ncsu.csc316.ancestrytree.list.ArrayList;

/**
 * Creates a traversal tree from pre and post order traversals
 * @author John Ruisi
 *
 */
public class TraversalTree {
	
	//Pre order traversal
	private ArrayList<Person> preOrder;
	//Post order traversal
	private ArrayList<Person> postOrder;
	//Root node
	private TreeNode root;
	
	/**
	 * Creates traversal tree from post and pre order traversals
	 * @param a pre order
	 * @param b post order
	 */
	public TraversalTree(ArrayList<Person> a, ArrayList<Person> b) {
		this.preOrder = a;
		this.postOrder = b;
		this.root = buildTree();
	}
	
	/**
	 * Gets root
	 * @return root the root
	 */
	public TreeNode getRoot() {
		return root;
	}
	
	/**
	 * Gets the pre order
	 * @return preOrder the pre order
	 */
	public ArrayList<Person> getPreorder() {
		return preOrder;
	}
	
	/**
	 * Gets the post order
	 * @return postOrder the post order
	 */
	public ArrayList<Person> getPostorder() {
		return postOrder;
	}
	
	/**
	 * Build tree from two traversal files
	 * @return the root node
	 */
	public TreeNode buildTree() {
		if (preOrder.size() != postOrder.size()) {
			throw new IllegalArgumentException("Pre and Post order not same size");
		}
		return buildTree(preOrder, 0, preOrder.size() - 1, postOrder, 0, postOrder.size() - 1);
	}
	
	/**
	 * Build tree
	 * @param preOrder the pre order traversal
	 * @param preMin the pre min index
	 * @param preMax the pre max index
	 * @param postOrder the post order traversal
	 * @param postMin the post min index
	 * @param postMax the post max index
	 * @return root the root node
	 */
	public TreeNode buildTree(ArrayList<Person> preOrder, int preMin, int preMax, ArrayList<Person> postOrder, int postMin, int postMax) {
		TreeNode node = new TreeNode();
		node.data = preOrder.get(preMin);
		
		int preIdx = preMin + 1;
		int postIdx = postMin;
		
		while (preIdx <= preMax && postIdx <= postMax - 1) {
			
			int count = 0;
			while (postOrder.get(postIdx + count).equals(preOrder.get(preIdx))) {
				count++;
			}
			
			TreeNode child = buildTree(preOrder, preIdx, preIdx + count, postOrder, postMin, postMin + count);
			child.parent = node;
			node.children.add(child);
			count++;
			preIdx = preIdx + count;
			postIdx = postIdx + count;
		}
		
		return node;
	}

	/**
	 * Tree node for traversal trees
	 * @author John Ruisi
	 *
	 */
	public class TreeNode {
		
		//Parent node
		private TreeNode parent;
		//Data for node
		private Person data;
		//Children of node
		private ArrayList<TreeNode> children;
		
		/**
		 * Creates tree node
		 */
		public TreeNode() {
			this.parent = null;
			this.children = new ArrayList<TreeNode>();
			this.data = null;
		}
		
		/**
		 * Gets parent
		 * @return parent the parent
		 */
		public TreeNode getParent() {
			return parent;
		}
		
		/**
		 * gets the data
		 * @return data the data
		 */
		public Person getData() {
			return data;
		}
		
		/**
		 * Gets the children
		 * @return children the children
		 */
		public ArrayList<TreeNode> getChildren() {
			return children;
		}
	}
}
